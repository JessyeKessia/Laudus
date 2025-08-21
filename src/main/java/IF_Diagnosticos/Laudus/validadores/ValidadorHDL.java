package IF_Diagnosticos.Laudus.validadores;

public class ValidadorHDL extends ValidadorBase {
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("HDL")) {
            return "Colesterol HDL: " + exame.getDadosResultantes() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Baixo: < 40 mg/dL (homens), < 50 mg/dL (mulheres)\n" +
                    "Normal: ≥ 40 mg/dL (homens), ≥ 50 mg/dL (mulheres)";
        } else {
            return super.handle(exame);
        }
    }
}
