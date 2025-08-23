package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;


public abstract class Laudo {
    private Exame exame;
    private String conteudo;
    protected LaudoFormato formatador;

    public Laudo (LaudoFormato formatador, Exame exame, String conteudo) {
        this.formatador = formatador;
        this.exame = exame;
        this.conteudo = conteudo;
    }

    public abstract String renderizar();
}

