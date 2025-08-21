package IF_Diagnosticos.Laudus.validadores;

public class ValidadorUreia extends ValidadorBase{
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("Ureia")) {
            return "Ureia: " + exame.getDadosResultantes() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Adultos: 15 – 40 mg/dL\n" +
                    "Idosos: 17 – 45 mg/dL\n" +
                    "Valores críticos: > 100 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
