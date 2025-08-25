package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.bridge.FormatoHTML;
import IF_Diagnosticos.Laudus.bridge.FormatoTXT;
import IF_Diagnosticos.Laudus.bridge.FormatoPDF;
import IF_Diagnosticos.Laudus.bridge.LaudoConcreto;
import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;

public class EmissorLaudo {

    private static final String PASTA_LAUDOS = "laudos";

    public File gerarArquivosLaudo(Exame exame, String conteudo) {
        File dir = new File(PASTA_LAUDOS);
        if (!dir.exists()) dir.mkdirs();
        LaudoConcreto txt = new LaudoConcreto(new FormatoTXT(), exame, conteudo);
        LaudoConcreto html = new LaudoConcreto(new FormatoHTML(), exame, conteudo);
        LaudoConcreto pdfLaudo = new LaudoConcreto(new FormatoPDF(), exame, conteudo);

        File pdfFile = null;
        try {
            File txtFile = txt.gerar();
            File htmlFile = html.gerar();
            pdfFile = pdfLaudo.gerar();

            if (txtFile != null) System.out.println("TXT gerado: " + txtFile.getAbsolutePath());
            if (htmlFile != null) System.out.println("HTML gerado: " + htmlFile.getAbsolutePath());
            if (pdfFile != null) System.out.println("PDF gerado: " + pdfFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdfFile;
    }
}
