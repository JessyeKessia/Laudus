package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaborial;

public class ValidadorAcidoUrico extends ValidadorBase{
    public String handle(ExameLaborial examesangue) {
        String tipo = examesangue.getEspecialidade();
        if (tipo != null && tipo.equalsIgnoreCase("Acido urico")) {
            return "Ácido úrico: " + examesangue.getValor() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Homens: 3,4 – 7,0 mg/dL\n" +
                    "Mulheres: 2,4 – 6,0 mg/dL\n" +
                    "Valores críticos: > 10 mg/dL";
        } else {
            return super.handle(examesangue);
        }
    }
}
