package IF_Diagnosticos.Laudus.formatoLaudo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormatoTexto implements FormatoLaudo {
    @Override
    public void gerarLaudo(String cabecalho, String corpo, String rodape, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo + ".txt"))) {
            writer.write("===== LAUDO EM TEXTO =====\n");
            writer.write(cabecalho + "\n\n");
            writer.write(corpo + "\n\n");
            writer.write(rodape);
            System.out.println("[OK] Laudo gerado em TXT: " + nomeArquivo + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
