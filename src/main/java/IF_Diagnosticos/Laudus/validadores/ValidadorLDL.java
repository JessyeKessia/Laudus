
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorLDL extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("LDL")) {
            return "Colesterol LDL: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Desejável: < 100 " + unidade + "\n" +
                   "Limítrofe: 100 – 129 " + unidade + "\n" +
                   "Alto: 130 – 159 " + unidade + "\n" +
                   "Muito alto: >= 160 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
