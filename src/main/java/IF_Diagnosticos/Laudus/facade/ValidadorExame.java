package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.bridge.Exame;
import IF_Diagnosticos.Laudus.bridge.LaudoSanguineo;
import IF_Diagnosticos.Laudus.factory.ExameRaioX;
import IF_Diagnosticos.Laudus.validadores.*;

public class ValidadorExame {
    public String validar(Exame exame) {
        System.out.println("\n--- Iniciando Validação ---");
        String CorpoValidado;

        if (exame instanceof LaudoSanguineo) {
            // Inicia a cadeia
            ValidadorSanguineo validadorGlicose = new ValidadorGlicose();
            ValidadorSanguineo validadorCreatinina = new ValidadorCreatinina();
            ValidadorSanguineo ValidadorHDL = new ValidadorHDL();
            ValidadorSanguineo validadorAcidoUrico = new ValidadorAcidoUrico();
            ValidadorSanguineo validadorUreia = new ValidadorUreia();
            ValidadorSanguineo validadorLDL = new ValidadorLDL();
            ValidadorSanguineo validadorColesterol = new ValidadorColesterol();
            ValidadorSanguineo validadorHemograma = new ValidadorHemograma();

            // Constrói a cadeia de responsabilidade
            validadorGlicose.setProximo(validadorCreatinina);
            ValidadorHDL.setProximo(validadorAcidoUrico);
            validadorUreia.setProximo(validadorCreatinina);
            validadorGlicose.setProximo(validadorLDL);
            validadorColesterol.setProximo(validadorHemograma);

            // Passa o exame para o primeiro elo da cadeia e retorna a string
            return validadorGlicose.handle(exame);

        } else if (exame instanceof ExameRaioX) {
            CorpoValidado = validarRaioX((ExameRaioX) exame);
        } else if (exame instanceof ExameRessonancia) {
            CorpoValidado = validarRessonancia((ExameRessonancia) exame);
        } else {
            CorpoValidado = "Tipo de exame desconhecido. Sem validação.";
        }

        System.out.println("--- Validação Concluída ---");
        return CorpoValidado;
    }
}
