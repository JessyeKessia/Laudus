package IF_Diagnosticos.Laudus.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Paciente {
    private String nome;
    private Convenio convenio;
    private String email;
    private LocalDate dataNascimento;
    private String telefone;
    private boolean eIdoso;

    public Paciente(String nome, Convenio convenio, LocalDate dataNascimento, String email, String telefone) {
        this.nome = nome;
        this.convenio = convenio;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public Convenio getConvenio() {
        return convenio;
    }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; };
    public String getDataNascimento () { return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); }
    public void verificarEIdoso() {
        if (dataNascimento != null) {
            int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
            this.eIdoso = idade >= 60;
        }
    }

    public void setNome(String nome) { this.nome = nome; }
    // public void setEmail(String email) { this.email = email; }
}