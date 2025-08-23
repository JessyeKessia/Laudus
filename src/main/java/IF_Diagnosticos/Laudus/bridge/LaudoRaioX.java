package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;


public class LaudoRaioX extends Laudo {

    public LaudoRaioX(Exame exame, LaudoFormato formatador, String conteudo) {
        super(exame, formatador, conteudo);
    }
    public String renderizar() {
        return formatador.formatarLaudo(formatador, exame, conteudo);
    }
}
