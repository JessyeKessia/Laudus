package IF_Diagnosticos.Laudus.validadores;

public class ValidadorHemograma extends ValidadorBase {
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("Hemograma")) {
            return "Hemoglobina: " + exame.getDadosResultantes() + " g/dL\n" +
                    "Valores de Referência:\n" +
                    "Homens: 13,5 – 17,5 g/dL\n" +
                    "Mulheres: 12,0 – 15,5 g/dL\n" +
                    "Crianças: 11,5 – 15,5 g/dL\n" +
                    "Valores críticos: < 7 g/dL (anemia grave), > 20 g/dL (policitemia)";
        } else {
            return super.handle(exame);
        }
    }
}
