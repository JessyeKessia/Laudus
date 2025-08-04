package IF_Diagnosticos.Laudus;

import IF_Diagnosticos.Laudus.Model.Entities.Exame;
import IF_Diagnosticos.Laudus.Model.Entities.Paciente;
import IF_Diagnosticos.Laudus.Model.Facate.FachadaNotificacaoComunicacao;
import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoHTML;
import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoPDF;
import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoTexto;
import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoLaudo;
import IF_Diagnosticos.Laudus.Model.Laudos.Laudo;
import IF_Diagnosticos.Laudus.Model.Laudos.LaudoHemograma;
import IF_Diagnosticos.Laudus.Model.Laudos.LaudoRessonancia;
import IF_Diagnosticos.Laudus.Model.Laudos.LaudoUltrassonografia;
import IF_Diagnosticos.Laudus.Utils.LeitorExameCSV;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // String caminhoCSV =
        // "src/main/java/IF_Diagnosticos/Laudus/Model/Dados/exames.csv";
        // List<Exame> exames = LeitorExameCSV.ler(caminhoCSV);

        // Scanner scanner = new Scanner(System.in);

        // System.out.println("=== Sistema de Laudos ===");

        // while (true) {
        // System.out.println("\n--- Nova Busca ---");
        // System.out.print("Digite o nome do paciente para gerar o laudo (ou 'sair'
        // para encerrar): ");

        // String nomeBuscado = scanner.nextLine().trim().toLowerCase();

        // // Opção para sair do loop
        // if (nomeBuscado.equals("sair")) {
        // System.out.println("Encerrando o sistema de laudos. Até mais!");
        // break; // Sai do loop 'while(true)'
        // }

        // boolean encontrado = false;

        // for (Exame exame : exames) {
        // String nomePaciente = exame.getPaciente().getNome().toLowerCase();

        // if (nomePaciente.equals(nomeBuscado)) {
        // encontrado = true;

        // // --- Lógica de escolha de formato (mantida) ---
        // FormatoLaudo formatoEscolhido = null;
        // boolean formatoValido = false;

        // while (!formatoValido) {
        // System.out.println("\nEscolha o formato do laudo para " +
        // exame.getPaciente().getNome() + ":");
        // System.out.println("1. Texto");
        // System.out.println("2. HTML");
        // System.out.println("3. PDF");
        // System.out.print("Digite o número da opção: ");
        // String opcaoFormato = scanner.nextLine().trim();

        // switch (opcaoFormato) {
        // case "1":
        // formatoEscolhido = new FormatoTexto();
        // formatoValido = true;
        // break;
        // case "2":
        // formatoEscolhido = new FormatoHTML();
        // formatoValido = true;
        // break;
        // case "3":
        // formatoEscolhido = new FormatoPDF();
        // formatoValido = true;
        // break;
        // default:
        // System.out.println("Opção inválida. Por favor, digite 1, 2 ou 3.");
        // }
        // }
        // // --- Fim da lógica de escolha de formato ---

        // Laudo laudo = switch (exame.getTipo().toLowerCase()) {
        // case "hemograma" -> new LaudoHemograma(formatoEscolhido);
        // case "ultrassonografia" -> new LaudoUltrassonografia(formatoEscolhido);
        // case "ressonancia" -> new LaudoRessonancia(formatoEscolhido);
        // default -> throw new IllegalArgumentException("Tipo de exame não suportado: "
        // + exame.getTipo());
        // };

        // laudo.gerar(exame, exame.getMedicoResponsavel());
        // System.out.println("✅ Laudo em formato " +
        // formatoEscolhido.getClass().getSimpleName().replace("Formato", "") + " gerado
        // para " + exame.getPaciente().getNome());
        // // Remover o `break` daqui para que, se houver múltiplos exames para o mesmo
        // paciente,
        // // ele gere laudos para todos. Se você quiser apenas o primeiro encontrado,
        // // adicione um `break;` aqui.
        // }
        // }

        // if (!encontrado) {
        // System.out.println("❌ Paciente não encontrado.");
        // }
        // } // Fim do loop 'while(true)'

        // scanner.close();

        // Cria a fachada de notificação com envio real de e-mail
        // FachadaNotificacaoComunicacao fachada = new FachadaNotificacaoComunicacao();
        // Paciente paciente = new Paciente("Danillo", null);
        // String mensagem = "Sua consulta está marcada para amanhã às 14h.";
        // fachada.enviarEmail(paciente, mensagem);


                // Instância da fachada
        FachadaNotificacaoComunicacao fachada = new FachadaNotificacaoComunicacao();
        Paciente paciente = new Paciente("Danillo", null);
        String mensagem = "Olá, Danillo! Seu exame já está disponível no sistema.";
        fachada.enviarTelegram(paciente, mensagem);
    }

}