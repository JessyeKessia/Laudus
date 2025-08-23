package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.utils.GeradorNumeroSequencial;

public class ExameLaboratorial implements Exame {
    private long numeroSequencial;
    private String tipo;
    private double valor;
    private String unidade;
    private Paciente paciente;
    private Medico medico;
    private String prioridade;


    public ExameLaboratorial(Paciente paciente, Medico medico, String prioridade, String tipo, double valor) {
        super(paciente, medico, prioridade, formato);
        this.numeroSequencial = GeradorNumeroSequencial.getInstancia().getProximoNumero();
        this.tipo = tipo;
        this.valor = valor;
        this.unidade = unidade;
    }

}