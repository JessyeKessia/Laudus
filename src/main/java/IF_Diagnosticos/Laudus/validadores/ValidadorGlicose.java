
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorGlicose extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("Glicose")) {
            return "Glicose: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Normal: 60 a 99 " + unidade + "\n" +
                   "Hipoglicemia: < 60 " + unidade + "\n" +
                   "Intolerante: 100 a 125 " + unidade + "\n" +
                   "Diabetes: >= 126 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
