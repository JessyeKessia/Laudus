
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorAcidoUrico extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("Acido urico")) {
            return "Ácido úrico: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Homens: 3.4 – 7.0 " + unidade + "\n" +
                   "Mulheres: 2.4 – 6.0 " + unidade + "\n" +
                   "Valores críticos: > 10 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
