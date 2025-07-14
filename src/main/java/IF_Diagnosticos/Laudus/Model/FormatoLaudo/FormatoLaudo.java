package IF_Diagnosticos.Laudus.Model.FormatoLaudo;

public interface FormatoLaudo {
    void gerarLaudo(String cabecalho, String corpo, String rodape, String nomeArquivo);
}