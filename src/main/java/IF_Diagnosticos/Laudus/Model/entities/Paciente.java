package IF_Diagnosticos.Laudus.Model.entities;

public class Paciente {
    private String nome;
    private String convenio;
    private String email;

    public Paciente(String nome, String convenio) {
        this.nome = nome;
        this.convenio = convenio;
       // this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public String getConvenio() {
        return convenio;
    }
   // public String getEmail() { return email; };

    public void setNome(String nome) { this.nome = nome; }
    public void setConvenio(String convenio) { this.convenio = convenio; }
    // public void setEmail(String email) { this.email = email; }
}