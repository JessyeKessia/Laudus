package IF_Diagnosticos.Laudus.Model.Laudos;

import IF_Diagnosticos.Laudus.Model.Entities.Exame;
import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoLaudo;

public class LaudoRessonancia extends Laudo {
    public LaudoRessonancia(FormatoLaudo formato) {
        super(formato);
    }

    @Override
    protected String gerarCorpo(Exame exame) {
        return "Tipo de Exame: " + exame.getTipo() + "\n" + exame.getResultados();
    }
}
