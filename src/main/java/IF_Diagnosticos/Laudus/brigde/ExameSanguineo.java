package IF_Diagnosticos.Laudus.brigde;

import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;

public class ExameSanguineo extends Exame {
    private double valor;
    private String unidade;

    public ExameSanguineo(String tipoExameLaboratorio, double valor, String unidade, Paciente paciente, Medico medicoSolicitante) {
        super(tipoExameLaboratorio, paciente, medicoSolicitante);
        this.valor = valor;
        this.unidade = unidade;
    }

    public double getValor() { return valor; }
    public String getUnidade() { return unidade; }
}