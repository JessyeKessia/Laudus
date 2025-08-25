package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.bridge.FormatoHTML;
import IF_Diagnosticos.Laudus.bridge.FormatoTXT;
import IF_Diagnosticos.Laudus.bridge.Laudo;
import IF_Diagnosticos.Laudus.bridge.LaudoConcreto;
import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;

public class EmissorLaudo {

    // Define o nome da pasta como uma constante para fácil alteração.
    private static final String PASTA_LAUDOS = "laudos";

    public File gerarArquivosLaudo(Exame exame, String conteudo) {
        // Garantir que a pasta exista
        File dir = new File(PASTA_LAUDOS);
        if (!dir.exists()) dir.mkdirs();
        // Cada formatador/adapter gera e grava seu próprio arquivo.
        Laudo txt = new LaudoConcreto(new FormatoTXT(), exame, conteudo);
        Laudo html = new LaudoConcreto(new FormatoHTML(), exame, conteudo);
    // cria o adaptador passando o serviço concreto
    IF_Diagnosticos.Laudus.adapter.PDFGeneratorAdapter pdfAdapter = new IF_Diagnosticos.Laudus.adapter.PDFGeneratorAdapter(new IF_Diagnosticos.Laudus.adapter.PDFService());
    Laudo pdfLaudo = new LaudoConcreto(pdfAdapter, exame, conteudo);

        File pdfFile = null;
        try {
            // cada gerar() já escreve o arquivo e retorna o File correspondente
            File txtFile = txt.gerar();
            File htmlFile = html.gerar();
            pdfFile = pdfLaudo.gerar();

            // opcional: logs mínimos
            if (txtFile != null) System.out.println("TXT gerado: " + txtFile.getAbsolutePath());
            if (htmlFile != null) System.out.println("HTML gerado: " + htmlFile.getAbsolutePath());
            if (pdfFile != null) System.out.println("PDF gerado: " + pdfFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdfFile;
    }
}
