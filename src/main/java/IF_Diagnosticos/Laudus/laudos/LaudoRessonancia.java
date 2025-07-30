package IF_Diagnosticos.Laudus.laudos;

import IF_Diagnosticos.Laudus.Model.entities.Exame;
import IF_Diagnosticos.Laudus.formatoLaudo.FormatoLaudo;

public class LaudoRessonancia extends Laudo {
    public LaudoRessonancia(FormatoLaudo formato) {
        super(formato);
    }

    @Override
    protected String gerarCorpo(Exame exame) {
        return "Tipo de Exame: " + exame.getTipo() + "\n" + exame.getResultados();
    }
}
