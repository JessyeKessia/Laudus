
package IF_Diagnosticos.Laudus.factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;
import IF_Diagnosticos.Laudus.utils.GeradorNumeroSequencial;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.pagamento.EstadoPagamento;
import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.pagamento.EstadoPagamento;
import IF_Diagnosticos.Laudus.pagamento.PagamentoPendente;


public abstract class Exame {
    private String numeroSequencial;
    private double valorBase;
    private String dataSolicitacao;
    private Prioridade prioridade;
    private Paciente paciente;
    private Medico medico;
    private EstadoPagamento estadoPagamento = new PagamentoPendente();

    // Construtor que aceita valorBase
    public Exame(Prioridade prioridade, Paciente paciente, Medico medico) {
        this.numeroSequencial = String.valueOf(GeradorNumeroSequencial.getInstancia().getProximoNumero());
        this.dataSolicitacao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.prioridade = prioridade;
        this.paciente = paciente;
        this.medico = medico;
    }
    public abstract String getTipo();
    public EstadoPagamento getEstadoPagamento() { return estadoPagamento; }
    public void setEstadoPagamento(IF_Diagnosticos.Laudus.pagamento.EstadoPagamento estadoPagamento) { this.estadoPagamento = estadoPagamento; }
    public String getNumeroSequencial() { return numeroSequencial; }
    public void setNumeroSequencial(String novo) { this.numeroSequencial = novo; }

    // precisa para aplicar os descontos nos exames
    public double getValorBase() { return valorBase; }
    public void setValorBase(double valorBase) { this.valorBase = valorBase; }

    public String getDataSolicitacao() { return dataSolicitacao; }
    public void setDataSolicitacao(String dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }

    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

}
