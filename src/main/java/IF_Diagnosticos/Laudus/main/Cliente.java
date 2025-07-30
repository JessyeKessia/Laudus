package IF_Diagnosticos.Laudus.main;

import IF_Diagnosticos.Laudus.Model.entities.Exame;
import IF_Diagnosticos.Laudus.utils.LeitorExameCSV;
import IF_Diagnosticos.Laudus.facade.EmissorLaudosFacade;

import java.util.List;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String caminhoCSV = "src/main/java/IF_Diagnosticos/Laudus/Model/Data/exames.csv";
        List<Exame> exames = LeitorExameCSV.ler(caminhoCSV);
        EmissorLaudosFacade emissor = new EmissorLaudosFacade(exames);

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistema de Laudos ===");

        while (true) {
            System.out.println("\n--- Nova Busca ---");
            System.out.print("Digite o nome do paciente para gerar o laudo (ou 'sair' para encerrar): ");
            String nomeBuscado = scanner.nextLine().trim();

            if (nomeBuscado.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o sistema de laudos. Até mais!");
                break;
            }

            System.out.println("\nEscolha o formato do laudo:");
            System.out.println("1. Texto");
            System.out.println("2. HTML");
            System.out.println("3. PDF");
            System.out.print("Digite o número da opção: ");
            String opcaoFormato = scanner.nextLine().trim();

            String formatoStr = switch (opcaoFormato) {
                case "1" -> "texto";
                case "2" -> "html";
                case "3" -> "pdf";
                default -> {
                    System.out.println("❌ Opção inválida. Tente novamente.");
                    yield null;
                }
            };

            // Aqui usamos a fachada
            try {
                emissor.emitirLaudo(nomeBuscado, formatoStr);
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}