package IF_Diagnosticos.Laudus.validadores;

public class ValidadorGlicose extends ValidadorBase {
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("GLICOSE")) {
            return exame.getDadosResultantes() + " Valores de Referência\n"
                    + "Normal: 60 a 99 mg/dL\n"
                    + "Hipoglicemia: < 60 mg/dL\n"
                    + "Intolerante: 100 a 125 mg/dL\n"
                    + "Diabetes: Acima de 125 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
