package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaborial;

public class ValidadorGlicose extends ValidadorBase {
    public String handle(ExameLaborial exame) {
        String tipo = exame.getEspecialidade();
        if (tipo != null && tipo.equalsIgnoreCase("GLICOSE")) {
            return exame.getValor() + " Valores de Referência\n"
                    + "Normal: 60 a 99 mg/dL\n"
                    + "Hipoglicemia: < 60 mg/dL\n"
                    + "Intolerante: 100 a 125 mg/dL\n"
                    + "Diabetes: Acima de 125 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
