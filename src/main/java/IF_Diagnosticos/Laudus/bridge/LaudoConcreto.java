package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;

public class LaudoConcreto {
    protected FormatoLaudo formato;
    protected Exame exame;
    protected String conteudo;

    public LaudoConcreto(FormatoLaudo formato, Exame exame, String conteudo) {
        this.formato = formato;
        this.exame = exame;
        this.conteudo = conteudo;
    }

    public File gerar() {
        return formato.gerar(exame, conteudo);
    }
}
