package IF_Diagnosticos.Laudus.validadores;

public class ValidadorLDL extends ValidadorBase {
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("LDL")) {
            return "Colesterol LDL: " + exame.getDadosResultantes() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Desejável: < 100 mg/dL\n" +
                    "Limítrofe: 100 – 129 mg/dL\n" +
                    "Alto: 130 – 159 mg/dL\n" +
                    "Muito alto: ≥ 160 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
