package IF_Diagnosticos.Laudus.Model.Entities;
import java.time.LocalDate;

public class Exame {
    private static int sequencialGlobal = 1;
    private int id;
    private String resultados;
    private String especialidade;
    private Paciente paciente;
    private Medico medicoSolicitante;
    private Medico medicoResponsavel;
    private String tipo;
    private LocalDate data;

    public Exame(Paciente paciente, Medico medicoSolicitante, Medico medicoResponsavel, String tipo, String resultados, String especialidade) {
        this.paciente = paciente;
        this.medicoSolicitante = medicoSolicitante;
        this.medicoResponsavel = medicoResponsavel;
        this.tipo = tipo;
        this.especialidade = especialidade;
        this.resultados = resultados;
        this.data = LocalDate.now();
        this.id = sequencialGlobal++;
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedicoSolicitante() { return medicoSolicitante; }
    public String getTipo() { return tipo; }
    public LocalDate getData() { return data; }
    public String getEspecialidade() { return especialidade; }
    public String getResultados() { return resultados; }

    public String getCabecalho() {
        return "Exame Nº: " + id + "\n" +
                "Paciente: " + paciente.getNome() + "\n" +
                "Convênio: " + (paciente.getConvenio()) + "\n" +
                "Médico Solicitante: " + medicoSolicitante.getNome() + "\n" +
                "Data: " + data;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}