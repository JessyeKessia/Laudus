package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.entidades.Medico;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class FormatoPDF implements FormatoLaudo {

    @Override
    public File gerar(Exame exame, String conteudo) {
        String nomeArquivo = "laudos/laudo_" + exame.getNumeroSequencial() + ".pdf";
        File arquivo = new File(nomeArquivo);

        // Garante que a pasta exista
        arquivo.getParentFile().mkdirs();

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.LETTER);
            doc.addPage(page);

            // Monte as linhas seguindo o layout do TXT
            List<String> linhas = new ArrayList<>();
            linhas.add("===== LAUDO MÉDICO =====");
            linhas.add("");
            linhas.add("Paciente: " + exame.getPaciente().getNome());
            linhas.add("Exame: " + exame.getTipo() + " - " + exame.getPrioridade());
            linhas.add("Convênio: " + exame.getPaciente().getConvenio());
            linhas.add("Data: " + exame.getDataSolicitacao());
            linhas.add("Idade: " + exame.getPaciente().getIdade() + " anos");
            linhas.add("");
            linhas.add(">>> RESULTADO <<<");
            for (String l : conteudo.split("\\n")) {
                linhas.add(l);
            }
            linhas.add("");
            Medico m = exame.getMedico();
            linhas.add("Médico Responsável: " + m.getNome() + " - CRM: " + m.getCrm());

            // Escrita por linhas, controlando paginação
            float marginLeft = 50;
            float startY = 700;
            float y = startY;
            float leading = 14; // espaço entre linhas
            PDPageContentStream cs = new PDPageContentStream(doc, page);
            try {
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 14);
                cs.newLineAtOffset(marginLeft, y);
                // Escrever a primeira linha (título)
                cs.showText(linhas.get(0));
                cs.endText();
                y -= leading * 2;

                // A partir daqui usamos fonte regular
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(marginLeft, y);
                for (int i = 1; i < linhas.size(); i++) {
                    String linha = linhas.get(i);
                    if (linha == null) linha = "";
                    // Se precisar de nova página
                    if (y < 70) {
                        cs.endText();
                        cs.close();
                        page = new PDPage(PDRectangle.LETTER);
                        doc.addPage(page);
                        cs = new PDPageContentStream(doc, page);
                        y = startY;
                        cs.beginText();
                        cs.setFont(PDType1Font.HELVETICA, 12);
                        cs.newLineAtOffset(marginLeft, y);
                    }
                    cs.showText(linha);
                    // mover para próxima linha (não passar '\n' para showText)
                    cs.newLineAtOffset(0, -leading);
                    y -= leading;
                }
                cs.endText();
            } finally {
                cs.close();
            }

            doc.save(arquivo);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return arquivo;
    }

}
