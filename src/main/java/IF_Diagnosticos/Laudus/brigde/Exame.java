package IF_Diagnosticos.Laudus.brigde;

import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;
import IF_Diagnosticos.Laudus.utils.GeradorNumeroSequencial;

// abstração do brigde
public abstract class Exame {
    private FormatoLaudo formato;
    private long numeroSequencial;
    private String tipoExame;
    private String unidade;
    private Paciente paciente;
    private Medico medicoSolicitante;
    private Prioridade prioridade;
    private double valorBase;

    public Exame(String tipoExame, Paciente paciente, Medico medicoSolicitante, Prioridade prioridade) {
        this.numeroSequencial = GeradorNumeroSequencial.getInstancia().getProximoNumero();
        this.tipoExame = tipoExame;
        this.prioridade = prioridade;
    }

    public String getNome() { return tipoExame; }
    public double getPreco() { return valorBase = 200; }
    public String getUnidade() { return unidade; }
    public Long getNumeroSequencial() { return numeroSequencial; }
    public Prioridade getPrioridade() { return prioridade; }
}