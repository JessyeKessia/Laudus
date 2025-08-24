package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;

public class LaudoConcreto extends Laudo {
    public LaudoConcreto(FormatoLaudo formato, Exame exame, String conteudo) {
        super(formato, exame, conteudo);
    }

    @Override
    public String gerar() {
        return formato.gerarConteudo(exame, conteudo);
    }
}
