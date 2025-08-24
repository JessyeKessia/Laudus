package IF_Diagnosticos.Laudus.main;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import IF_Diagnosticos.Laudus.entidades.*;
import IF_Diagnosticos.Laudus.factory.*;
import IF_Diagnosticos.Laudus.facade.*;
import IF_Diagnosticos.Laudus.notificacao.*;
import IF_Diagnosticos.Laudus.pagamento.*;
import IF_Diagnosticos.Laudus.prioridade.*;
import IF_Diagnosticos.Laudus.utils.LeitorCSV;

public class Cliente {

    private static double parseValor(String raw) {
        if (raw == null) return 0.0;
        raw = raw.replace(',', '.'); // decimal
        int i = 0;
        StringBuilder num = new StringBuilder();
        while (i < raw.length()) {
            char c = raw.charAt(i);
            if ((c >= '0' && c <= '9') || c == '.' || (c == '-' && num.length() == 0)) {
                num.append(c);
            } else if (num.length() > 0) break;
            i++;
        }
        try {
            return Double.parseDouble(num.toString());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        String caminho = args.length > 0 ? args[0] : "exames.csv";
        if (!new File(caminho).exists()) {
            System.out.println("CSV não encontrado em " + new File(caminho).getAbsolutePath());
            return;
        }

        // --- Configuração da Infraestrutura (Injeção de Dependência Manual) ---

        // 1. Criar a dependência de baixo nível: EmailSender
        // ATENÇÃO: Use uma "Senha de App" para o Gmail.
        EmailSender emailSender = new EmailSender(
            "nillocoelho@gmail.com",       // Usuário
            "mtvm nvgc ryol tfmx",          // Senha de App
            "smtp.gmail.com",              // Host SMTP
            587                            // Porta TLS
        );

        // 2. Injetar a dependência (EmailSender) na classe que a utiliza (Fachada)
        FachadaNotificacaoComunicacao fachadaCom = new FachadaNotificacaoComunicacao(emailSender);

        // 3. Configurar o padrão Observer com a fachada já pronta.
        AssuntoNotificacao assunto = new AssuntoNotificacao();
        assunto.adicionarObservador(new NotificadorEmail(fachadaCom));
        assunto.adicionarObservador(new NotificadorTelegram(fachadaCom));

        // 4. Montar a Fachada Principal do Sistema.
        ValidadorExame validador = new ValidadorExame();
        FilaPrioridade fila = new FilaPrioridade();
        EmissorLaudo emissor = new EmissorLaudo();
        Pagamento pagamento = new Pagamento();
        
        SistemaDiagnosticoFacade sistema = new SistemaDiagnosticoFacade(validador, fila, emissor, assunto, pagamento);

        // --- Leitura e Processamento dos Dados do CSV ---
        LeitorCSV leitor = new LeitorCSV(caminho);
        List<String[]> linhas = leitor.lerLinhas();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean outubro = LocalDate.now().getMonthValue() == 10;

        for (String[] col : linhas) {
            if (col.length < 12) continue;
            
            // ... (o restante do seu loop 'for' para ler e processar o CSV continua exatamente igual)
            String nome = col[0];
            String convenio = col[1];
            LocalDate dataNasc = LocalDate.parse(col[2], f);
            String email = col[3];
            String telefone = col[4];
            Paciente paciente = new Paciente(nome, convenio, dataNasc, email, telefone);

            Medico medicoSolic = new Medico(col[5], col[6]);

            String tipoExame = col[7];
            String subtipo = col[8];
            String resultados = col[9];

            Prioridade prioridade = paciente.isIdoso() ? Prioridade.POUCO_URGENTE : Prioridade.ROTINA;

            Exame exame;
            if ("Raio-X".equalsIgnoreCase(tipoExame)) {
                exame = ExameSimpleFactory.criarExameRaioX(paciente, medicoSolic, prioridade, subtipo, resultados);
            } else if ("Ressonância".equalsIgnoreCase(tipoExame)) {
                boolean utilizouContraste = col.length > 10 && Boolean.parseBoolean(col[10]);
                String tipoContraste = col.length > 11 ? col[11] : "";
                double dosagemContraste = col.length > 12 ? parseValor(col[12]) : 0.0;
                boolean possuiMarcapasso = col.length > 13 && Boolean.parseBoolean(col[13]);
                boolean possuiImplantesMetalicos = col.length > 14 && Boolean.parseBoolean(col[14]);
                exame = ExameSimpleFactory.criarExameRessonancia(paciente, medicoSolic, prioridade, subtipo, utilizouContraste, tipoContraste, dosagemContraste, possuiMarcapasso, possuiImplantesMetalicos);
            } else {
                double valor = parseValor(resultados);
                String unidade = resultados != null && resultados.contains(" ") ? resultados.split(" ")[1].replace(";", "") : "u";
                exame = ExameSimpleFactory.criarExameLaboratorial(paciente, medicoSolic, prioridade, tipoExame, valor, unidade);
            }

            sistema.processar(exame, outubro);
        }

        System.out.println("\nProcessamento concluído.");
    }
}