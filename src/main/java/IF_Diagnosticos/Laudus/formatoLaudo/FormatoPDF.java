package IF_Diagnosticos.Laudus.formatoLaudo;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;

public class FormatoPDF implements FormatoLaudo {
    public void gerarLaudo(String cabecalho, String corpo, String rodape, String nomeArquivo) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(nomeArquivo + ".pdf"));
            doc.open();
            doc.add(new Paragraph("IF Diagnósticos", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            doc.add(new Paragraph(cabecalho));
            doc.add(new Paragraph("\n" + corpo));
            doc.add(new Paragraph("\n" + rodape, FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE)));
            doc.close();
            System.out.println("[OK] Laudo gerado em PDF: " + nomeArquivo + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

