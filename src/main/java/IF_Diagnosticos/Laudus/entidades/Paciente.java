
package IF_Diagnosticos.Laudus.entidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paciente {
    private String nome;
    private String convenio;
    private String email;
    private LocalDate dataNascimento;
    private String telefone;

    public Paciente(String nome, String convenio, LocalDate dataNascimento, String email, String telefone) {
        this.nome = nome;
        this.convenio = convenio;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public String getConvenio() { return convenio; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public String getDataNascimento() {
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public int getIdade() { return Period.between(dataNascimento, LocalDate.now()).getYears(); }

    public boolean isIdoso() { return getIdade() >= 60; }
}
