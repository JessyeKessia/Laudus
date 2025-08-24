
package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public class ValidadorCreatinina extends ValidadorBase {
    public String handle(ExameLaboratorial exame){
        String tipo = exame.getTipo();
        String unidade = exame.getUnidade().toString();
        if (tipo != null && tipo.equalsIgnoreCase("Creatinina")) {
            return "Creatinina: " + exame.getValorMedido() + " " + unidade + "\n" +
                   "Valores de Referência:\n" +
                   "Adultos (Homens): 0,50 – 1,30 " + unidade + "\n" +
                   "Adultos (Mulheres): 0,40 – 1,10 " + unidade + "\n" +
                   "Idosos (>60 anos): 0,30 – 1,20 " + unidade + "\n" +
                   "Crianças: 0,20 – 0,50 " + unidade;
        } else {
            return super.handle(exame);
        }
    }
}
