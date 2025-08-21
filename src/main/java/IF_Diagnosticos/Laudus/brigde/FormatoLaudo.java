package IF_Diagnosticos.Laudus.brigde;

import IF_Diagnosticos.Laudus.entities.Convenio;
import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;

public interface FormatoLaudo {
    String formatarCabecalho(Paciente paciente, Medico medicoSolicitante, Convenio convenio);
    String formatarCorpo(String conteudo);
    String formatarRodape(Medico medicoResponsavel);
}