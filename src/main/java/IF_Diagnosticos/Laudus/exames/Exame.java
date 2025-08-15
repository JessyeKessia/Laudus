package IF_Diagnosticos.Laudus.exames;
import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;
import IF_Diagnosticos.Laudus.laudos.FormatoLaudo;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Exame {
    protected FormatoLaudo formatoLaudo;
    protected String idExame;
    protected String tipo;
    protected Paciente paciente;
    protected Prioridade prioridade;
    protected Medico medicoSolicitante;
    protected Medico medicoResponsavel;
    protected LocalDate data;
    protected String dadosResultantes;

    public Exame(Paciente paciente, Medico medicoSolicitante, Medico medicoResponsavel, String dadosResultantes, Prioridade prioridade, String tipo) {
        this.prioridade = prioridade;
        this.tipo = tipo;
        this.paciente = paciente;
        this.medicoSolicitante = medicoSolicitante;
        this.medicoResponsavel = medicoResponsavel;
        this.dadosResultantes = dadosResultantes;
        this.data = LocalDate.now();
    }
    public String getIdExame() { return idExame; }
    public String getDadosResultantes() { return dadosResultantes; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedicoResponsavel() { return medicoResponsavel; }
    public Medico getMedicoSolicitante() { return medicoSolicitante; }
    public String getData() { return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); }
    public Prioridade getPrioridade() { return prioridade; }
    public String getTipo() { return tipo; }

    public abstract String toString();
    public abstract void emitirLaudo();
}