

package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameLaboratorial extends Exame {
    private String tipo;      // ex: "Hemograma"
    private double valorMedido;   // ex: 13.5
    private String unidade;       // ex: g/dL

    public ExameLaboratorial(Paciente paciente, Medico solicitante, Medico responsavel, Prioridade prioridade, String tipo, double valorMedido, String unidade) {
        super(prioridade, paciente, solicitante);
        this.tipo = tipo;
        this.valorMedido = valorMedido;
        this.unidade = unidade;
        setValorBase(200); 
    }

    public double getValorMedido(){ return valorMedido; }
    public String getUnidade(){ return unidade; }
    public String getTipo(){ return tipo; }
}
