package IF_Diagnosticos.Laudus.adapter;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class GeradorPDFService {

    // pasta de destino
    private final String pastaDestino = "emissoes";

    public void gerarPDF(String textoCompleto, String nomeArquivo) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pastaDestino + "/" + nomeArquivo));
            document.open();

            for (String linha : textoCompleto.split("\n")) {
                document.add(new Paragraph(linha));
            }

            document.close();
            System.out.println("Laudo PDF gerado com sucesso: " + nomeArquivo);

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

}
