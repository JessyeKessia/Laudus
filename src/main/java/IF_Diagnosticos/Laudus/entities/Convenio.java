package IF_Diagnosticos.Laudus.entities;

public class Convenio {
    private String nome;
    private String codigo;

    public Convenio(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
