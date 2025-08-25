package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.entidades.Medico;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FormatoHTML implements FormatoLaudo {
    @Override
    public File gerar(Exame exame, String conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("  <head>\n");
        sb.append("    <meta charset='utf-8'>\n");
        sb.append("    <title>Laudo</title>\n");
        sb.append("  </head>\n");
        sb.append("  <body>\n");
        sb.append("    <img src='Laudus/src/main/java/IF_Diagnosticos/Laudus/logo/logo.png' alt='Logo IF Diagnósticos' class='logo'/>\n");
        sb.append("    <h2>Laboratório IF Diagnósticos</h2>\n");

        sb.append("    <p><b>Paciente:</b> ").append(exame.getPaciente().getNome()).append("</p>\n");
        sb.append("    <p><b>Exame:</b> ").append(exame.getTipo()).append(" - ").append(exame.getPrioridade()).append("</p>\n");
        sb.append("    <p><b>Convênio:</b> ").append(exame.getPaciente().getConvenio()).append("</p>\n");
        sb.append("    <p><b>Data:</b> ").append(exame.getDataSolicitacao()).append("</p>\n");
        sb.append("    <p><b>Idade:</b> ").append(exame.getPaciente().getIdade()).append(" anos</p>\n");
        sb.append("    <hr/>\n");
        sb.append("    <pre>").append(conteudo).append("</pre>\n");

        Medico m = exame.getMedico();
        sb.append("    <p><i>Médico Responsável:</i> ")
        .append(m.getNome())
        .append(" - CRM: ")
        .append(m.getCrm())
        .append("</p>\n");

        sb.append("  </body>\n");
        sb.append("</html>\n");

        // Cria o arquivo com o conteúdo formatado
        File arquivo = new File("laudos/laudo_" + exame.getNumeroSequencial() + ".html");
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arquivo;
    }
}
