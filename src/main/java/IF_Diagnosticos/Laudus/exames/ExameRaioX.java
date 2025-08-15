package IF_Diagnosticos.Laudus.exames;

import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameRaioX extends Exame{
    public ExameRaioX(Paciente paciente, Medico medicoSolicitante, Medico medicoResponsavel, String dadosResultantes,  Prioridade prioridade, String tipo) {
        super(paciente, medicoSolicitante, medicoResponsavel, dadosResultantes, prioridade, tipo);
    }

    public void emitirLaudo() {
        formatoLaudo.gerarLaudo(this);
    }

    public String toString() { return getIdExame() + " - " + "Raio X: " + getTipo() + " - " + getPrioridade() + " - " + getData(); }
}
