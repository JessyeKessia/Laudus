package IF_Diagnosticos.Laudus.validadores;

public class ValidadorColesterol extends ValidadorBase {
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("Colesterol")) {
            return "Colesterol total: " + exame.getDadosResultantes() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Alto: ≥ 240 mg/dL (aumenta risco cardiovascular)\n" +
                    "Limítrofe: 200 – 239 mg/dL\n" +
                    "Desejável: ≥ 200 mg/dL (fator protetor)";
        } else {
            return super.handle(exame);
        }
    }
}