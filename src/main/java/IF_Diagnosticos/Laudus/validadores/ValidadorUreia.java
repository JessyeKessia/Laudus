package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaborial;

public class ValidadorUreia extends ValidadorBase{
    public String handle(ExameLaborial exame) {
        String tipo = exame.getEspecialidade();
        if (tipo != null && tipo.equalsIgnoreCase("Ureia")) {
            return "Ureia: " + exame.getValor() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Adultos: 15 – 40 mg/dL\n" +
                    "Idosos: 17 – 45 mg/dL\n" +
                    "Valores críticos: > 100 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
