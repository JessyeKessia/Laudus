package IF_Diagnosticos.Laudus.bridge;
import IF_Diagnosticos.Laudus.entidades.Medico;


public class FormatoHTML implements LaudoFormato {

    public String formatarLaudo(Exame exame, Medico Responsavel, String conteudoLaudo) {
        StringBuilder writer = new StringBuilder();

        // Cabeçalho em HTML
        writer.append("<!DOCTYPE html>");
        writer.append("<html lang=\"pt-BR\">");
        writer.append("<head>");
        writer.append("    <meta charset=\"UTF-8\">");
        writer.append("    <title>Laudo de ").append(exame.getTipo()).append("</title>");
        writer.append("    <style>");
        writer.append("        body { font-family: Arial, sans-serif; font-size: 12px; }");
        writer.append("        .header { text-align: center; margin-bottom: 20px; }");
        writer.append("        .header img { width: 200px; height: auto; }");
        writer.append("        .info { margin-bottom: 10px; }");
        writer.append("        .info p { margin: 2px 0; }");
        writer.append("        .bold { font-weight: bold; }");
        writer.append("        .rodape { margin-top: 30px; font-size: 11px; text-align: center; }");
        writer.append("        .assinatura { margin-top: 50px; text-align: center; }");
        writer.append("    </style>");
        writer.append("</head>");
        writer.append("<body>");

        // Cabeçalho do laboratório
        writer.append("    <div class=\"header\">");
        writer.append("        <img src=\"logo/logo.png\" alt=\"Logo do Laboratório\">");
        writer.append("        <h2>Laboratório IF Diagnósticos</h2>");
        writer.append("    </div>");

        // Informações principais do laudo
        writer.append("    <div class=\"info\">");
        writer.append("        <p><span class=\"bold\">Sr(a):</span> ").append(exame.getPaciente().getNome()).append("</p>");
        writer.append("        <p><span class=\"bold\">Dr(a):</span> ").append(exame.getMedicoSolicitante().getNome()).append("</p>");
        writer.append("        <p><span class=\"bold\">Coleta:</span> ")
                .append(exame.getPaciente().getConvenio())
                .append(" - Local D.N: ").append(exame.getData())
                .append(" <span class=\"bold\">Idade:</span> ").append(exame.getPaciente().getIdade()).append(" anos</p>");
        writer.append("        <p><span class=\"bold\">Data Nascimento:</span> ").append(exame.getPaciente().getDataNascimento()).append("</p>");
        writer.append("    </div>");

        // Seção do exame
        writer.append("    <h3>Exame: ").append(exame.getTipo()).append("</h3>");
        writer.append("    <div class=\"corpo\">");
        writer.append("        <p>").append(conteudoLaudo).append("</p>");
        writer.append("    </div>");
        writer.append("    <div class=\"assinatura\">");
        writer.append("        <p>____________________________________</p>");
        writer.append("        <p>").append(Responsavel.getNome()).append("</p>");
        writer.append("        <p><em>Médico Responsável - CRM: ").append(Responsavel.getCrm()).append("</em></p>");
        writer.append("    </div>");

        writer.append("    <div class=\"rodape\">");
        writer.append("        <p>Este laudo é confidencial e destinado exclusivamente ao paciente.</p>");
        writer.append("    </div>");
        writer.append("</body>");
        writer.append("</html>");

        return writer.toString();

    };

}
