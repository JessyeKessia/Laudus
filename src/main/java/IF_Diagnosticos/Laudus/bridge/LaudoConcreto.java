package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;

public class LaudoConcreto extends Laudo {
    public LaudoConcreto(FormatoLaudo formato, Exame exame, String conteudo) {
        super(formato, exame, conteudo);
    }

    @Override
    public File gerar() {
        return formato.gerar(exame, conteudo);
    }
}
