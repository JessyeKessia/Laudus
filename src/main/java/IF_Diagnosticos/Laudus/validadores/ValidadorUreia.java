
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorUreia extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("Ureia")) {
            return "Ureia: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Adultos: 15 – 40 " + unidade + "\n" +
                   "Idosos: 17 – 45 " + unidade + "\n" +
                   "Valores críticos: > 100 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
