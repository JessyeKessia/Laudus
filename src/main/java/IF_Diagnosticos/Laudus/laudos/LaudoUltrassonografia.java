package IF_Diagnosticos.Laudus.laudos;

import IF_Diagnosticos.Laudus.Model.entities.Exame;
import IF_Diagnosticos.Laudus.formatoLaudo.FormatoLaudo;

public class LaudoUltrassonografia extends Laudo{
    public LaudoUltrassonografia(FormatoLaudo formato) {
        super(formato);
    }

    @Override
    protected String gerarCorpo(Exame exame) {
        return "Tipo de Exame: " + exame.getTipo() + "\n" + exame.getResultados();
    }
}
