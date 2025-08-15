package IF_Diagnosticos.Laudus.laudos;

import IF_Diagnosticos.Laudus.exames.Exame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormatoHTML implements FormatoLaudo {
    @Override
    public void gerarLaudo(Exame exame) {
        // Nome do arquivo
        String nomeArquivo = exame.getPaciente().getNome();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo + ".html"))) {
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang='pt-br'>\n");
            writer.write("<head>\n");
            writer.write("<meta charset='UTF-8'>\n");
            writer.write("<title>Laudo - " + exame.getIdExame() + "</title>\n");
            writer.write("<style>\n");
            writer.write("body { font-family: Arial, sans-serif; margin: 20px; }\n");
            writer.write("h1 { text-align: center; }\n");
            writer.write(".cabecalho, .corpo, .rodape { margin: 20px 0; }\n");
            writer.write(".rodape { font-style: italic; }\n");
            writer.write("</style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");

            // Logo
            String caminhoLogo = "src/main/java/IF_Diagnosticos/Laudus/logo/OIG1.jpg";
            if (caminhoLogo != null && !caminhoLogo.isEmpty()) {
                writer.write("<div style='text-align:center;'>\n");
                writer.write("<img src='" + caminhoLogo + "' alt='Logo IF Diagnósticos' width='100'/>\n");
                writer.write("</div>\n");
            }

            // Título
            writer.write("<h1>IF Diagnósticos</h1>\n");

            // Cabeçalho
            writer.write("<div class='cabecalho'>\n");
            writer.write("<strong>Exame Nº:</strong> " + exame.getIdExame() + "<br/>\n");
            writer.write("<strong>Paciente:</strong> " + exame.getPaciente().getNome() + "<br/>\n");
            writer.write("<strong>Médico Solicitante:</strong> " + exame.getMedicoSolicitante().getNome() + "<br/>\n");
            writer.write("<strong>Data:</strong> " + exame.getData() + "<br/>\n");
            writer.write("</div>\n");

            // Corpo
            writer.write("<div class='corpo'>\n");
            writer.write(exame.getDadosResultantes().replaceAll("\n", "<br/>") + "\n");
            writer.write("</div>\n");

            // Rodapé
            writer.write("<div class='rodape'>\n");
            writer.write("Médico Responsável: " + exame.getMedicoResponsavel().getNome() + "\n");
            writer.write("</div>\n");

            writer.write("</body>\n");
            writer.write("</html>\n");

            System.out.println("[OK] Laudo gerado em HTML: " + nomeArquivo + ".html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
