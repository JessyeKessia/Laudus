
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorHemograma extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("Hemograma")) {
            return "Hemograma - Hemoglobina: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Homens: 13,5 – 17,5 " + unidade + "\n" +
                   "Mulheres: 12,0 – 15,5 " + unidade + "\n" +
                   "Crianças: 11,5 – 15,5 " + unidade + "\n" +
                   "Críticos: < 7 " + unidade + " ou > 20 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
