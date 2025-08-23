package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.utils.GeradorNumeroSequencial;

public class ExameRessonancia implements Exame {
    private long numeroSequencial;
    private String tipo;
    private String descricao;
    private String imagemRef;
    private String contraste;

    public ExameRessonancia(String tipo, String imagemRef, String contraste) {
        this.numeroSequencial = GeradorNumeroSequencial.getInstancia().getProximoNumero();
        this.tipo = tipo;
        this.descricao = null;
        this.imagemRef = imagemRef;
        this.contraste = contraste;
    }

    public String getImagem() { return imagemRef; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao;}
    public String getConstraste() { return contraste; }
}