package IF_Diagnosticos.Laudus.adapter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFGeneratorAdapter implements PDFGenerator {
    @Override
    public void gerarPDF(String nomeArquivo, String conteudo) {
        // Simulação: gera um arquivo .pdf simples com o texto (sem formatação real de PDF)
        try (FileOutputStream fos = new FileOutputStream(nomeArquivo)) {
            fos.write(conteudo.getBytes());
            System.out.println("Arquivo PDF gerado: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
