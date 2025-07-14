package IF_Diagnosticos.Laudus.Model.Entities;

public class Paciente {
    private String nome;
    private String convenio;

    public Paciente(String nome, String convenio, String medicoSolicitante) {
        this.nome = nome;
        this.convenio = convenio;
    }
    public String getNome() {
        return nome;
    }

    public String getConvenio() {
        return convenio;
    }
}