
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

    private static double parseValor(String raw){
        if (raw == null) return 0.0;
        raw = raw.replace(',', '.'); // decimal
        int i = 0;
        StringBuilder num = new StringBuilder();
        while (i < raw.length()) {
            char c = raw.charAt(i);
            if ((c >= '0' && c <= '9') || c == '.' || (c=='-' && num.length()==0)) {
                num.append(c);
            } else if (num.length() > 0) break;
            i++;
        }
        try { return Double.parseDouble(num.toString()); } catch(Exception e){ return 0.0; }
    }

    public static void main(String[] args) {
        String caminho = args.length > 0 ? args[0] : "exames.csv";
        if (!new File(caminho).exists()) {
            System.out.println("CSV não encontrado em " + new File(caminho).getAbsolutePath());
            return;
        }

        // Infra
        ValidadorExame validador = new ValidadorExame();
        FilaPrioridade fila = new FilaPrioridade();
        EmissorLaudo emissor = new EmissorLaudo();
        AssuntoNotificacao assunto = new AssuntoNotificacao();
        FachadaNotificacaoComunicacao fachadaCom = new FachadaNotificacaoComunicacao();
        assunto.adicionarObservador(new NotificadorEmail(fachadaCom));
        assunto.adicionarObservador(new NotificadorTelegram(fachadaCom));
        Pagamento pagamento = new Pagamento();
        EmailSender emailSender = new EmailSender();
        SistemaDiagnosticoFacade sistema = new SistemaDiagnosticoFacade(validador, fila, emissor, assunto, pagamento, emailSender);

    
        LeitorCSV leitor = new LeitorCSV(caminho);
        List<String[]> linhas = leitor.lerLinhas();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean outubro = LocalDate.now().getMonthValue() == 10;

        for (String[] col : linhas) {

            if (col.length < 12) continue;
            String nome = col[0];
            String convenio = col[1];
            LocalDate dataNasc = LocalDate.parse(col[2], f);
            String email = col[3];
            String telefone = col[4];
            Paciente paciente = new Paciente(nome, convenio, dataNasc, email, telefone);

            Medico medicoSolic = new Medico(col[5], col[6]);

            String tipoExame = col[7]; // indexação ajustada
            String subtipo = col[8];   // indexação ajustada
            String resultados = col[9]; // indexação ajustada

            Prioridade prioridade = paciente.isIdoso() ? Prioridade.POUCO_URGENTE : Prioridade.ROTINA;

            Exame exame;
            if ("Raio-X".equalsIgnoreCase(tipoExame)) {
                // Exame Raio-X: regiao = subtipo, imagem = resultados
                exame = ExameSimpleFactory.criarExameRaioX(paciente, medicoSolic, prioridade, subtipo, resultados);
            } else if ("Ressonância".equalsIgnoreCase(tipoExame)) {
                // Exame Ressonância: regiao = subtipo, demais campos fictícios
                boolean utilizouContraste = col.length > 10 && Boolean.parseBoolean(col[10]);
                String tipoContraste = col.length > 11 ? col[11] : "";
                double dosagemContraste = col.length > 12 ? parseValor(col[12]) : 0.0;
                boolean possuiMarcapasso = col.length > 13 && Boolean.parseBoolean(col[13]);
                boolean possuiImplantesMetalicos = col.length > 14 && Boolean.parseBoolean(col[14]);
                exame = ExameSimpleFactory.criarExameRessonancia(paciente, medicoSolic, prioridade, subtipo, utilizouContraste, tipoContraste, dosagemContraste, possuiMarcapasso, possuiImplantesMetalicos);
            } else {
                // Exame Laboratorial: tipo = tipoExame, valorMedido = parseValor(resultados), unidade
                double valor = parseValor(resultados);
                String unidade = resultados != null && resultados.contains(" ") ? resultados.split(" ")[1].replace(";", "") : "u";
                exame = ExameSimpleFactory.criarExameLaboratorial(paciente, medicoSolic, prioridade, tipoExame, valor, unidade);
            }

            // Processar via fachada (pagamento->fila->validacao->emissao->notificacao)
            sistema.processar(exame, outubro);
        }

        System.out.println("\nProcessamento concluído.");
    }
}
