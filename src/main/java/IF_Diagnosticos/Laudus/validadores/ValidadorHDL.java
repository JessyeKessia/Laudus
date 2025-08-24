
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorHDL extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("HDL")) {
            return "Colesterol HDL: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Baixo: < 40 " + unidade + " (homens), < 50 " + unidade + " (mulheres)\n" +
                   "Normal: >= 40 " + unidade + " (homens), >= 50 " + unidade + " (mulheres)";
        } else {
            return super.handle(exame);
        }
    }
}
