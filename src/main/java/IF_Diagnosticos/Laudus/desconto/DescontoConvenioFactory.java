package IF_Diagnosticos.Laudus.desconto;

import IF_Diagnosticos.Laudus.factory.Exame;

public class DescontoConvenioFactory {
    public static Exame criarDescontoConvenio(Exame exame) {
        String convenio = "";
        if (exame.getPaciente() != null && exame.getPaciente().getConvenio() != null) {
            convenio = exame.getPaciente().getConvenio();
        }
        switch (convenio.toLowerCase()) {
            case "unimed":
                return new ExameDescontoConvenio(exame, 0.10);
            case "amil":
                return new ExameDescontoConvenio(exame, 0.08);
            default:
                return new ExameDescontoConvenio(exame, 0.05);
        }
    }
}
