package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;
import IF_Diagnosticos.Laudus.factory.ExameRaioX;
import IF_Diagnosticos.Laudus.factory.ExameRessonancia;
import IF_Diagnosticos.Laudus.validadores.*;
import java.util.Scanner;

public class ValidadorExame {

    private final Scanner scanner = new Scanner(System.in);

    // CORREÇÃO PRINCIPAL: O tipo de retorno do método foi alterado de 'String' para 'ResultadoValidacao'
    public ResultadoValidacao validar(Exame exame) {
        System.out.println("\n--- INICIANDO VALIDAÇÃO PARA O PACIENTE: " + exame.getPaciente().getNome() + " ---");
        ResultadoValidacao resultado;

        if (exame instanceof ExameLaboratorial lab) {
            String conteudo = validarExameLaboratorial(lab);
            resultado = new ResultadoValidacao(true, conteudo);
        } else if (exame instanceof ExameRaioX rx) {
            String conteudo = validarExameRaioX(rx);
            resultado = new ResultadoValidacao(true, conteudo);
        } else if (exame instanceof ExameRessonancia rm) {
            resultado = validarExameRessonancia(rm);
        } else {
            resultado = new ResultadoValidacao(false, "Tipo de exame desconhecido. Sem validação.");
        }

        System.out.println("--- VALIDAÇÃO CONCLUÍDA ---");
        return resultado;
    }

    private String validarExameLaboratorial(ExameLaboratorial lab) {
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
        return v1.handle(lab);
    }

    private String validarExameRaioX(ExameRaioX rx) {
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
        return "Região Examinada: " + rx.getRegiao() + "\n\n" +
               "Descrição do Laudo:\n" + rx.getLaudoDescricao();
    }

    // Este método também foi ajustado para retornar 'ResultadoValidacao'
    private ResultadoValidacao validarExameRessonancia(ExameRessonancia rm) {
        if (rm.isPossuiMarcapasso() || rm.isPossuiImplantesMetalicos()) {
            String motivo = rm.isPossuiMarcapasso() ? "possui marcapasso cardíaco" : "possui implantes metálicos";
            System.out.println("⚠️ ALERTA: Exame de Ressonância cancelado. Paciente " + motivo + ".");
            return new ResultadoValidacao(false, "Exame cancelado devido a contraindicação: paciente " + motivo + ".");
        }

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
        String conteudoFinal = "Região Examinada: " + rm.getRegiao() + "\n" +
                             "Contraste Utilizado: " + contrasteInfo + "\n\n" +
                             "Descrição do Laudo:\n" + rm.getLaudoDescricao();
        return new ResultadoValidacao(true, conteudoFinal);
    }
}