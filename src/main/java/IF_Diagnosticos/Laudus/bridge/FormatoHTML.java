package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.entidades.Medico;

public class FormatoHTML implements FormatoLaudo {
    @Override
    public String gerarConteudo(Exame exame, String conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta charset='utf-8'><title>Laudo</title></head><body>");
        sb.append("<h2>Laboratório IF Diagnósticos</h2>");
        sb.append("<p><b>Paciente:</b> ").append(exame.getPaciente().getNome()).append("</p>");
        sb.append("<p><b>Exame:</b> ").append(exame.getTipo()).append(" - ").append(exame.getPrioridade()).append("</p>");
        sb.append("<p><b>Convênio:</b> ").append(exame.getPaciente().getConvenio()).append("</p>");
        sb.append("<p><b>Data:</b> ").append(exame.getDataSolicitacao()).append("</p>");
        sb.append("<p><b>Idade:</b> ").append(exame.getPaciente().getIdade()).append(" anos</p>");
        sb.append("<hr/><pre>").append(conteudo).append("</pre>");
        Medico m = exame.getMedico();
        sb.append("<p><i>Médico Responsável:</i> ").append(m.getNome()).append(" - CRM: ").append(m.getCrm()).append("</p>");
        sb.append("</body></html>");
        return sb.toString();
    }
}
