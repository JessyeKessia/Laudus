
package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.factory.*;
import IF_Diagnosticos.Laudus.validadores.*;

public class ValidadorExame {

    public String validar(Exame exame){
        System.out.println("\n--- Iniciando Validação ---");
        String corpo;

        if (exame instanceof ExameLaboratorial lab) {
            
            // cria a cadeia
            ValidadorLaboratorial v1 = new ValidadorGlicose();
            ValidadorLaboratorial v2 = new ValidadorCreatinina();
            ValidadorLaboratorial v3 = new ValidadorHDL();
            ValidadorLaboratorial v4 = new ValidadorLDL();
            ValidadorLaboratorial v5 = new ValidadorColesterol();
            ValidadorLaboratorial v6 = new ValidadorUreia();
            ValidadorLaboratorial v7 = new ValidadorAcidoUrico();
            ValidadorLaboratorial v8 = new ValidadorHemograma();

            v1.setProximo(v2); v2.setProximo(v3); v3.setProximo(v4); v4.setProximo(v5);
            v5.setProximo(v6); v6.setProximo(v7); v7.setProximo(v8);

            corpo = v1.handle(lab);

        } else if (exame instanceof ExameRaioX rx) {
            // Não pode ta vazia
            if (rx.getLaudoDescricao() == null || rx.getLaudoDescricao().isEmpty()) {
                // pergunta a descrição
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                // cria o input
                String input = "";
                // coloca num loop e só sai se o safado colocar a descrição
                do {
                    System.out.print("Digite a descrição do laudo para Raio-X (" + rx.getRegiao() + "): ");
                    input = scanner.nextLine();
                    if (input == null || input.isEmpty()) {
                        System.out.println("A descrição não pode ser vazia. Por favor, digite novamente.");
                    }
                } while (input == null || input.isEmpty());
                rx.setLaudoDescricao(input);
                corpo = input;
            } else {
                // envia a descrição e a imagem formatada bonitinho para ser impressa
                corpo = "\n" + rx.getImagem() + "\n" + rx.getLaudoDescricao() + "\n";
            }
        } else if (exame instanceof ExameRessonancia rm) {
            // Validação de marcapasso e implantes metálicos
            if (rm.isPossuiMarcapasso() || rm.isPossuiImplantesMetalicos()) {
                corpo = "Paciente possui marcapasso cardíaco ou implantes metálicos. Ressonância CANCELADA. Nenhum laudo será gerado.";
            } else {
                // Descrição do laudo
                if (rm.getLaudoDescricao() == null || rm.getLaudoDescricao().isEmpty()) {
                    java.util.Scanner scanner = new java.util.Scanner(System.in);
                    String input = "";
                    do {
                        System.out.print("Digite a descrição do laudo para Ressonância (" + rm.getRegiao() + "): ");
                        input = scanner.nextLine();
                        if (input == null || input.isEmpty()) {
                            System.out.println("A descrição não pode ser vazia. Por favor, digite novamente.");
                        }
                    } while (input == null || input.isEmpty());
                    rm.setLaudoDescricao(input);
                }
                // Pergunta apenas se utilizou contraste
                if (!rm.getUtilizouContraste()) {
                    java.util.Scanner scanner = new java.util.Scanner(System.in);
                    String resposta = "";
                    do {
                        System.out.print("Utilizou contraste? (s/n): ");
                        resposta = scanner.nextLine().trim().toLowerCase();
                    } while (!resposta.equals("s") && !resposta.equals("n"));
                    rm.setUtilizouContraste(resposta.equals("s"));
                }
                String contrasteInfo = rm.getUtilizouContraste() ? "\n Contraste utilizado." : "";
                corpo = "Ressonância (" + rm.getRegiao() + "):\n" + rm.getLaudoDescricao() + contrasteInfo;
            }
        } else {
            corpo = "Tipo de exame desconhecido. Sem validação.";
        }

        System.out.println("--- Validação Concluída ---");
        return corpo;
    }
}
