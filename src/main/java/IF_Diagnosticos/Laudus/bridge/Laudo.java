package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;

public abstract class Laudo {
    protected FormatoLaudo formato;
    protected Exame exame;
    protected String conteudo;

    public Laudo(FormatoLaudo formato, Exame exame, String conteudo) {
        this.formato = formato;
        this.exame = exame;
        this.conteudo = conteudo;
    }

    public abstract String gerar();
}
