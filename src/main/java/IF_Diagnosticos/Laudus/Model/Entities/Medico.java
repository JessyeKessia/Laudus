package IF_Diagnosticos.Laudus.Model.Entities;

public class Medico {
    private String crm;
    private String nome;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    // Getters necessarios
    public String getAssinatura() {
        return "(" + nome + " " +  crm + ")";
    }

    public String getNome() {
        return nome;
    }
}
