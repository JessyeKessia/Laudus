package IF_Diagnosticos.Laudus.validadores;

public class ValidadorCreatinina extends ValidadorBase {
    public String handle(Laudo exame) {
        String tipo = exame.getTipo();
        if (tipo != null && tipo.equalsIgnoreCase("Creatinina")) {
            return "Creatinina: " + exame.getDadosResultantes() + " mg/dL\n" +
                    "Valores de Referência:\n" +
                    "Adultos (Homens): 0,50 – 1,30 mg/dL\n" +
                    "Adultos (Mulheres): 0,40 – 1,10 mg/dL\n" +
                    "Idosos (>60 anos): 0,30 – 1,20 mg/dL\n" +
                    "Crianças: 0,20 – 0,50 mg/dL\n" +
                    "Valores críticos:\n" +
                    "Homens > 1,5 mg/dL, Mulheres > 1,2 mg/dL, Idosos > 1,5 mg/dL, Crianças > 0,8 mg/dL";
        } else {
            return super.handle(exame);
        }
    }
}
