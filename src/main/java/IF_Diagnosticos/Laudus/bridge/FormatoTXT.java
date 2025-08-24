package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.entidades.Medico;

public class FormatoTXT implements FormatoLaudo {
    @Override
    public String gerarConteudo(Exame exame, String conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== LAUDO MÉDICO =====\n\n");
        sb.append("Paciente: ").append(exame.getPaciente().getNome()).append("\n");
        sb.append("Exame: ").append(exame.getTipo()).append(" - ").append(exame.getPrioridade()).append("\n");
        sb.append("Convênio: ").append(exame.getPaciente().getConvenio()).append("\n");
        sb.append("Data: ").append(exame.getDataSolicitacao()).append("\n");
        sb.append("Idade: ").append(exame.getPaciente().getIdade()).append(" anos\n\n");
        sb.append(">>> RESULTADO <<<\n");
        sb.append(conteudo).append("\n\n");
        Medico m = exame.getMedico();
        sb.append("Médico Responsável: ").append(m.getNome()).append(" - CRM: ").append(m.getCrm()).append("\n");
        return sb.toString();
    }
}
