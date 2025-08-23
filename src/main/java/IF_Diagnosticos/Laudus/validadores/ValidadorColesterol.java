package IF_Diagnosticos.Laudus.validadores;


import IF_Diagnosticos.Laudus.factory.ExameLaborial;

public class ValidadorColesterol extends ValidadorBase {
    public String handle(ExameLaborial examesangue) {
        String tipo = examesangue.getEspecialidade();
        if (tipo != null && tipo.equalsIgnoreCase("Colesterol")) {
            return "Colesterol total: " + examesangue.getValor() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Alto: ≥ 240 mg/dL (aumenta risco cardiovascular)\n" +
                    "Limítrofe: 200 – 239 mg/dL\n" +
                    "Desejável: ≥ 200 mg/dL (fator protetor)";
        } else {
            return super.handle(examesangue);
        }
    }
}