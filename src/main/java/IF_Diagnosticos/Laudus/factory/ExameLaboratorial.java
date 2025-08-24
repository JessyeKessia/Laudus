package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameLaboratorial extends Exame {
    private String tipo;
    private double valorMedido;
    private String unidade;

    public ExameLaboratorial(Paciente paciente, Medico solicitante, Medico responsavel, Prioridade prioridade, String tipo, double valorMedido, String unidade, double valorBase) {
        super(prioridade, paciente, solicitante);
        this.tipo = tipo;
        this.valorMedido = valorMedido;
        this.unidade = unidade;
        
        setValorBase(valorBase); 
    }

    public double getValorMedido() { return valorMedido; }
    public String getUnidade() { return unidade; }
    public String getTipo() { return tipo; }
}
