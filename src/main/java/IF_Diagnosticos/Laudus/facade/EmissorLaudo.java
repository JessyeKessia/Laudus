

package IF_Diagnosticos.Laudus.facade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import IF_Diagnosticos.Laudus.adapter.PDFGenerator;
import IF_Diagnosticos.Laudus.adapter.PDFGeneratorAdapter;
import IF_Diagnosticos.Laudus.bridge.FormatoHTML;
import IF_Diagnosticos.Laudus.bridge.FormatoTXT;
import IF_Diagnosticos.Laudus.bridge.Laudo;
import IF_Diagnosticos.Laudus.bridge.LaudoConcreto;
import IF_Diagnosticos.Laudus.factory.Exame;

public class EmissorLaudo {
    private final File pasta = new File("emissoes");

    public EmissorLaudo(){
        if (!pasta.exists()) pasta.mkdirs();
    }

    public void gerarArquivosLaudo(Exame exame, String conteudo) {
        Laudo txt = new LaudoConcreto(new FormatoTXT(), exame, conteudo);
        Laudo html = new LaudoConcreto(new FormatoHTML(), exame, conteudo);
        PDFGenerator pdfAdapter = new PDFGeneratorAdapter();
        try {
            File txtFile = new File(pasta, "laudo_" + exame.getNumeroSequencial() + ".txt");
            FileWriter txtWriter = new FileWriter(txtFile);
            txtWriter.write(txt.gerar());
            txtWriter.close();
            System.out.println("Arquivo gerado: " + txtFile.getAbsolutePath());

            File htmlFile = new File(pasta, "laudo_" + exame.getNumeroSequencial() + ".html");
            FileWriter htmlWriter = new FileWriter(htmlFile);
            htmlWriter.write(html.gerar());
            htmlWriter.close();
            System.out.println("Arquivo gerado: " + htmlFile.getAbsolutePath());

            // PDF
            String pdfPath = new File(pasta, "laudo_" + exame.getNumeroSequencial() + ".pdf").getAbsolutePath();
            pdfAdapter.gerarPDF(pdfPath, txt.gerar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
