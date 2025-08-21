package IF_Diagnosticos.Laudus.brigde;

import IF_Diagnosticos.Laudus.entities.Convenio;
import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;

public class FormatoTexto implements FormatoLaudo {

    public String formatarCabecalho(Paciente paciente, Medico medico, Convenio convenio) {
        return "--- Laudo IF Diagnósticos ---\nPaciente: " + paciente.getNome() + "\nConvênio: " + convenio.getNome() +
                "\nMédico Solicitante: " + medico.getNome() + " " + medico.getCrm() +"\n\n";
    }

    public String formatarCorpo(String dadosResultantes) {
        return "Diagnostico:\n" + dadosResultantes + "\n";
    }

    public String formatarRodape(Medico medicoResponsavel) {
        return "\n" + medicoResponsavel;
    }
}
