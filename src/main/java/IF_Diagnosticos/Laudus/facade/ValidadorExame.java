package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;
import IF_Diagnosticos.Laudus.factory.ExameRaioX;
import IF_Diagnosticos.Laudus.factory.ExameRessonancia;
import IF_Diagnosticos.Laudus.validadores.*;
import java.util.Scanner;

public class ValidadorExame {

    // Usamos uma única instância de Scanner para toda a classe
    private final Scanner scanner = new Scanner(System.in);

    public String validar(Exame exame) {
        System.out.println("\n--- INICIANDO VALIDAÇÃO PARA O PACIENTE: " + exame.getPaciente().getNome() + " ---");
        String corpo;

        if (exame instanceof ExameLaboratorial lab) {
            corpo = validarExameLaboratorial(lab);
        } else if (exame instanceof ExameRaioX rx) {
            corpo = validarExameRaioX(rx);
        } else if (exame instanceof ExameRessonancia rm) {
            corpo = validarExameRessonancia(rm);
        } else {
            corpo = "Tipo de exame desconhecido. Sem validação.";
        }

        System.out.println("--- VALIDAÇÃO CONCLUÍDA ---");
        return corpo;
    }

    private String validarExameLaboratorial(ExameLaboratorial lab) {
        // Configura a cadeia de responsabilidade (Chain of Responsibility)
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

        // Inicia a validação na cadeia
        return v1.handle(lab);
    }

    private String validarExameRaioX(ExameRaioX rx) {
        // Se a descrição do laudo não existir, solicita ao usuário.
        if (rx.getLaudoDescricao() == null || rx.getLaudoDescricao().isBlank()) {
            String input;
            do {
                System.out.print("➡️ Digite a descrição do laudo para Raio-X (" + rx.getRegiao() + "): ");
                input = scanner.nextLine();
                if (input == null || input.isBlank()) {
                    System.out.println("❌ A descrição não pode ser vazia. Por favor, digite novamente.");
                }
            } while (input == null || input.isBlank());
            rx.setLaudoDescricao(input);
        }
        // Retorna a descrição para ser usada no corpo do laudo.
        return "Região Examinada: " + rx.getRegiao() + "\n\n" +
               "Descrição do Laudo:\n" + rx.getLaudoDescricao();
    }

    private String validarExameRessonancia(ExameRessonancia rm) {
        // Validação crítica: verifica contraindicações.
        if (rm.isPossuiMarcapasso() || rm.isPossuiImplantesMetalicos()) {
            String motivo = rm.isPossuiMarcapasso() ? "possui marcapasso cardíaco" : "possui implantes metálicos";
            System.out.println("⚠️ ALERTA: Exame de Ressonância cancelado. Paciente " + motivo + ".");
            return "Paciente possui contraindicação (" + motivo + "). Ressonância CANCELADA. Nenhum laudo será gerado.";
        }

        // Se a descrição do laudo não existir, solicita ao usuário.
        if (rm.getLaudoDescricao() == null || rm.getLaudoDescricao().isBlank()) {
            String input;
            do {
                System.out.print("➡️ Digite a descrição do laudo para Ressonância (" + rm.getRegiao() + "): ");
                input = scanner.nextLine();
                if (input == null || input.isBlank()) {
                    System.out.println("❌ A descrição não pode ser vazia. Por favor, digite novamente.");
                }
            } while (input == null || input.isBlank());
            rm.setLaudoDescricao(input);
        }

        String contrasteInfo = rm.getUtilizouContraste() ? "Sim" : "Não";
        return "Região Examinada: " + rm.getRegiao() + "\n" +
               "Contraste Utilizado: " + contrasteInfo + "\n\n" +
               "Descrição do Laudo:\n" + rm.getLaudoDescricao();
    }
}