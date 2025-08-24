
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorColesterol extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("Colesterol")) {
            return "Colesterol total: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Alto: >= 240 " + unidade + "\n" +
                   "Limítrofe: 200 – 239 " + unidade + "\n" +
                   "Desejável: < 200 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
