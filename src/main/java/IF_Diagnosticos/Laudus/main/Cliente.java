package IF_Diagnosticos.Laudus.main;

import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;
import IF_Diagnosticos.Laudus.exames.Exame;
import IF_Diagnosticos.Laudus.exames.ExameRaioX;
import IF_Diagnosticos.Laudus.exames.ExameSanguineo;
//import IF_Diagnosticos.Laudus.laudos.FormatoLaudo;
import IF_Diagnosticos.Laudus.prioridade.FilaPrioridade;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;
//import IF_Diagnosticos.Laudus.utils.LeitorExameCSV;
//import IF_Diagnosticos.Laudus.facade.EmissorLaudosFacade;


public class Cliente {
    public static void main(String[] args) {
//        String caminhoCSV = "src/main/java/IF_Diagnosticos/Laudus/Model/Data/exames.csv";
//        List<Exame> exames = LeitorExameCSV.ler(caminhoCSV);
//        EmissorLaudosFacade emissor = new EmissorLaudosFacade(exames);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("=== Sistema de Laudos ===");
//
//        while (true) {
//            System.out.println("\n--- Nova Busca ---");
//            System.out.print("Digite o nome do paciente para gerar o laudo (ou 'sair' para encerrar): ");
//            String nomeBuscado = scanner.nextLine().trim();
//
//            if (nomeBuscado.equalsIgnoreCase("sair")) {
//                System.out.println("Encerrando o sistema de laudos. Até mais!");
//                break;
//            }
//
//            System.out.println("\nEscolha o formato do laudo:");
//            System.out.println("1. Texto");
//            System.out.println("2. HTML");
//            System.out.println("3. PDF");
//            System.out.print("Digite o número da opção: ");
//            String opcaoFormato = scanner.nextLine().trim();
//
//            String formatoStr = switch (opcaoFormato) {
//                case "1" -> "texto";
//                case "2" -> "html";
//                case "3" -> "pdf";
//                default -> {
//                    System.out.println("❌ Opção inválida. Tente novamente.");
//                    yield null;
//                }
//            };
//
//            // Aqui usamos a fachada
//            try {
//                emissor.emitirLaudo(nomeBuscado, formatoStr);
//            } catch (IllegalArgumentException e) {
//                System.out.println("⚠️ Erro: " + e.getMessage());
//            }
//        }
//
//        scanner.close();
        // teste do bridge
        // Criando pacientes e médicos
//        Paciente paciente = new Paciente("João da Silva", "Convênio XYZ");
//        Medico medicoSolicitante = new Medico("Dra. Maria Oliveira", "23223");
//        Medico medicoResponsavel = new Medico("Dr. Carlos Pereira", "2323");
//
//        // Criando exame (exemplo: glicose)
//        String resultados = "GLICOSE: 83 mg/dL\nValores de referência: 60-99 mg/dL";
//        Exame exame = new ExameSanguineo(paciente, medicoSolicitante, medicoResponsavel, resultados);
//
//        // Gerando laudo em TXT
//        FormatoTexto laudoTXT = new FormatoTexto();
//        laudoTXT.gerarLaudo(exame);
//
//        // Gerando laudo em HTML (com logo opcional)
//        FormatoHTML laudoHTML = new FormatoHTML();
//        laudoHTML.gerarLaudo(exame);
//
//        // Gerando laudo em PDF
//        FormatoPDF laudoPDF = new FormatoPDF();
//        laudoPDF.gerarLaudo(exame);
//
//        System.out.println("Laudos gerados com sucesso!");

        // teste da fila de prioridade
        // cria a fila
        FilaPrioridade fila = new FilaPrioridade();

        // Criando alguns exames
        Paciente paciente = new Paciente("João da Silva", "Convênio XYZ");
        Medico medicoSolicitante = new Medico("Dra. Maria Oliveira", "23223");
        Medico medicoResponsavel = new Medico("Dr. Carlos Pereira", "2323");
        String resultados = "GLICOSE: 83 mg/dL\nValores de referência: 60-99 mg/dL";

        Paciente paciente2 = new Paciente("Gabriela", "Unimed");
        Medico medicoSolicitante2 = new Medico("Dra. Helena Dinas", "345435");
        Medico medicoResponsavel2 = new Medico("Dr. João Silva", "5454");
        String resultados2 = "12121212";

        Exame e1 = new ExameSanguineo(paciente, medicoSolicitante, medicoResponsavel, resultados, Prioridade.ROTINA);
        Exame e2 = new ExameRaioX(paciente2, medicoSolicitante2, medicoResponsavel2, resultados2, Prioridade.URGENTE);

        // Adicionando na fila
        fila.adicionarExame(e1); // ROTINA → final
        fila.adicionarExame(e2); // URGENTE → início

        // Exibindo a fila final
        System.out.println("\n=== Fila Final ===");
        fila.listarFila().forEach(System.out::println);

        // Processando exames
        System.out.println("\n=== Processando ===");
        while (!fila.listarFila().isEmpty()) {
            Exame proximo = fila.processarProximo();
            System.out.println("Processando: " + proximo);
        }
    }
}