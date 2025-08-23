package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaborial;

public class ValidadorHDL extends ValidadorBase {
    public String handle(ExameLaborial exame) {
        String tipo = exame.getEspecialidade();
        if (tipo != null && tipo.equalsIgnoreCase("HDL")) {
            return "Colesterol HDL: " + exame.getValor() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Baixo: < 40 mg/dL (homens), < 50 mg/dL (mulheres)\n" +
                    "Normal: ≥ 40 mg/dL (homens), ≥ 50 mg/dL (mulheres)";
        } else {
            return super.handle(exame);
        }
    }
}
