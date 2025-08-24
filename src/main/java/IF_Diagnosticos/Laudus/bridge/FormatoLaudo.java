package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;

public interface FormatoLaudo {
    String gerarConteudo(Exame exame, String conteudo);
}
