package IF_Diagnosticos.Laudus.formatoLaudo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormatoHTML implements FormatoLaudo {
    @Override
    public void gerarLaudo(String cabecalho, String corpo, String rodape, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo + ".html"))) {
            String html = """
                <html>
                  <head><title>Laudo Médico</title></head>
                  <body>
                    <h2>ST Diagnósticos</h2>
                    <section><pre>%s</pre></section>
                    <section><pre>%s</pre></section>
                    <footer><em>%s</em></footer>
                  </body>
                </html>
                """.formatted(cabecalho, corpo, rodape);

            writer.write(html);
            System.out.println("[OK] Laudo gerado em HTML: " + nomeArquivo + ".html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
