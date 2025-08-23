package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.factory.Exame;

public class FormatoTexto implements LaudoFormato {
    public String formatarLaudo(Exame exame, Medico Responsavel, String conteudoLaudo) {
        StringBuilder sb = new StringBuilder();

        sb.append("============================================\n");
        sb.append("          LABORATÓRIO IF DIAGNÓSTICOS        \n");
        sb.append("============================================\n\n");

        sb.append("Paciente: ").append(exame.getPaciente().getNome()).append("\n");
        sb.append("Médico(a): ").append(exame.getMedico().getNome()).append("\n");
        sb.append("Convênio: ").append(exame.getPaciente().getConvenio()).append("\n");
        sb.append("Coleta: ").append(exame.getData()).append("   Idade: ").append(exame.getPaciente().getIdade()).append(" anos\n");

        sb.append("Exame: ").append(exame.getTipo()).append("\n");
        sb.append("--------------------------------------------\n");

        sb.append(conteudoLaudo).append("\n");
        sb.append("--------------------------------------------\n");

        sb.append("\n");

        sb.append("Assinatura: _______________________________\n");
        sb.append(Responsavel.getNome()).append("\n");
        sb.append("CRM: ").append(Responsavel.getCrm()).append("\n\n");

        sb.append("============================================\n");
        sb.append("Este laudo é confidencial e destinado\n");
        sb.append("exclusivamente ao paciente.\n");
        sb.append("============================================\n");

        return sb.toString();
    }
}
