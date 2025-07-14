package IF_Diagnosticos.Laudus.Model.Entities;

public class Medico {
    private String crn;
    private String nome;

    public Medico(String crm, String nome, String especialidade) {
        this.crn = crm;
        this.nome = nome;
    }

    // Getters necessarios
    public String getAssinatura() {
        return nome + " (CRN " + crn + ")";
    }

    public String getNome() {
        return nome;
    }
}
