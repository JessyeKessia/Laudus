package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmissorLaudo {

    // Define o nome da pasta como uma constante para fácil alteração.
    private static final String PASTA_LAUDOS = "laudos";

    public File gerarArquivosLaudo(Exame exame, String conteudo) {
        
        // 1. Cria um objeto File para o diretório.
        File diretorio = new File(PASTA_LAUDOS);

        // 2. Verifica se o diretório não existe e, se não, o cria.
        if (!diretorio.exists()) {
            System.out.println("Criando pasta para os laudos em: " + diretorio.getAbsolutePath());
            diretorio.mkdirs(); // mkdirs() cria diretórios pais se necessário.
        }

        String nomeBase = "laudo_" + exame.getPaciente().getNome().replaceAll("\\s+", "_") + "_" + System.currentTimeMillis();
        
        // 3. Monta o caminho base para os arquivos DENTRO da pasta.
        String caminhoCompletoBase = Paths.get(PASTA_LAUDOS, nomeBase).toString();
        
        System.out.println("Gerando laudos para o paciente: " + exame.getPaciente().getNome());

        // Gera os outros formatos já no caminho correto.
        gerarLaudoTxt(caminhoCompletoBase + ".txt", conteudo);
        gerarLaudoHtml(caminhoCompletoBase + ".html", conteudo);

        // Cria o arquivo PDF final no caminho correto.
        File pdfFile = new File(caminhoCompletoBase + ".pdf");

        try {
            String conteudoPdf = "--- LAUDO MÉDICO EM PDF ---\n\n" + conteudo;
            Files.write(pdfFile.toPath(), conteudoPdf.getBytes());
            
            System.out.println("Laudo em PDF gerado com sucesso em: " + pdfFile.getAbsolutePath());
            
            return pdfFile;

        } catch (IOException e) {
            System.err.println("Erro crítico ao gerar o arquivo PDF: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private void gerarLaudoTxt(String caminhoCompleto, String conteudo) {
        try {
            String conteudoTxt = "--- LAUDO MÉDICO (.txt) ---\n\n" + conteudo;
            Files.write(Paths.get(caminhoCompleto), conteudoTxt.getBytes());
            System.out.println("Laudo em TXT gerado: " + caminhoCompleto);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo TXT: " + e.getMessage());
        }
    }

    private void gerarLaudoHtml(String caminhoCompleto, String conteudo) {
        try {
            String conteudoHtml = "<html><body><h1>Laudo Médico</h1><p>" + conteudo.replace("\n", "<br>") + "</p></body></html>";
            Files.write(Paths.get(caminhoCompleto), conteudoHtml.getBytes());
            System.out.println("Laudo em HTML gerado: " + caminhoCompleto);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo HTML: " + e.getMessage());
        }
    }
}
