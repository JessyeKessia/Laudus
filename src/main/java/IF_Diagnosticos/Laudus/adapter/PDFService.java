package IF_Diagnosticos.Laudus.adapter;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFService implements PDFGenerator {
    @Override
    public void gerarPDF(String nomeArquivo, String conteudo) {
        File out = new File(nomeArquivo);
        File dir = out.getParentFile();
        if (dir != null && !dir.exists()) dir.mkdirs();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(50, 700);

                String[] lines = conteudo.split("\\r?\\n");
                for (String line : lines) {
                    contentStream.showText(line);
                    contentStream.newLine();
                }

                contentStream.endText();
            }

            document.save(out.getAbsolutePath());
            System.out.println("Arquivo PDF gerado (service): " + out.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
