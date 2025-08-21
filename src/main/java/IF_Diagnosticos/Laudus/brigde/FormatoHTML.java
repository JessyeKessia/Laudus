package IF_Diagnosticos.Laudus.brigde;

import IF_Diagnosticos.Laudus.entities.Convenio;
import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;

public class FormatoHTML implements FormatoLaudo {
    public String formatarCabecalho(Paciente paciente, Medico medico, Convenio convenio) {
        return "<html><head><title>Laudo</title></head><body><h1>ST Diagnósticos</h1><p>Paciente: " + paciente +
                "</p><p>Convênio: " + convenio + "</p><p>Médico Solicitante: " + medico + "</p>";
    }

    public String formatarCorpo(String dadosResultantes) {
        return "<h2>Diagnostico</h2><p>" + dadosResultantes + "</p>";
    }

    public String formatarRodape(String medicoResponsavel) {
        return "<p>" + medicoResponsavel + "</p></body></html>";
    }
}
