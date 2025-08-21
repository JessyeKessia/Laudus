package IF_Diagnosticos.Laudus.validadores;

public class ValidadorAcidoUrico extends ValidadorBase{
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("Acido urico")) {
            return "Ácido úrico: " + exame.getDadosResultantes() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Homens: 3,4 – 7,0 mg/dL\n" +
                    "Mulheres: 2,4 – 6,0 mg/dL\n" +
                    "Valores críticos: > 10 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
