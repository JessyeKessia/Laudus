package IF_Diagnosticos.Laudus.facade;

public class ResultadoValidacao {
    private final boolean sucesso;
    private final String conteudo;

    public ResultadoValidacao(boolean sucesso, String conteudo) {
        this.sucesso = sucesso;
        this.conteudo = conteudo;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getConteudo() {
        return conteudo;
    }
}
