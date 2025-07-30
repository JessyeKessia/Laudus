package IF_Diagnosticos.Laudus.Model.entities;

public class Medico {
    private String crm;
    private String nome;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }
    public String getCrm() { return crm; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCrm(String crm) { this.crm = crm; }
}
