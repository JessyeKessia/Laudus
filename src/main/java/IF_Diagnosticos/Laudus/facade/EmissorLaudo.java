package IF_Diagnosticos.Laudus.facade; // Certifique-se de que o pacote está correto

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EmissorLaudo {

    // Se você tiver outros métodos ou lógica (Bridge/Adapter), eles permanecem
    // aqui.

    /**
     * Gera os diversos formatos de laudo para um exame e seu conteúdo.
     * Ao final, retorna o objeto File referente ao PDF gerado.
     *
     * @param exame    O exame a ser processado.
     * @param conteudo O conteúdo validado do laudo.
     * @return O objeto File do PDF gerado, ou null em caso de erro.
     */
    public File gerarArquivosLaudo(Exame exame, String conteudo) {

        // --- CORREÇÃO APLICADA AQUI ---
        // Usamos System.currentTimeMillis() para garantir um nome de arquivo único.
        String nomeBase = "laudo_" + exame.getPaciente().getNome().replaceAll("\\s+", "_") + "_"
                + System.currentTimeMillis();

        System.out.println("Gerando laudos para o paciente: " + exame.getPaciente().getNome());

        // Simulação da geração de outros formatos (opcional)
        gerarLaudoTxt(nomeBase + ".txt", conteudo);
        gerarLaudoHtml(nomeBase + ".html", conteudo);

        // Lógica principal: gerar e retornar o arquivo PDF
        File pdfFile = new File(nomeBase + ".pdf");

        try {
            // Simula a escrita de um conteúdo específico para PDF no arquivo
            String conteudoPdf = "--- LAUDO MÉDICO EM PDF ---\n\n" + conteudo;
            Files.write(Paths.get(pdfFile.getAbsolutePath()), conteudoPdf.getBytes());

            System.out.println("Laudo em PDF gerado com sucesso em: " + pdfFile.getAbsolutePath());

            return pdfFile;

        } catch (IOException e) {
            System.err.println("Erro crítico ao gerar o arquivo PDF: " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }

    // Métodos auxiliares privados para gerar outros formatos (exemplo)
    private void gerarLaudoTxt(String nomeArquivo, String conteudo) {
        try {
            String conteudoTxt = "--- LAUDO MÉDICO (.txt) ---\n\n" + conteudo;
            Files.write(Paths.get(nomeArquivo), conteudoTxt.getBytes());
            System.out.println("Laudo em TXT gerado: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo TXT: " + e.getMessage());
        }
    }

    private void gerarLaudoHtml(String nomeArquivo, String conteudo) {
        try {
            String conteudoHtml = "<html><body><h1>Laudo Médico</h1><p>" + conteudo.replace("\n", "<br>")
                    + "</p></body></html>";
            Files.write(Paths.get(nomeArquivo), conteudoHtml.getBytes());
            System.out.println("Laudo em HTML gerado: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo HTML: " + e.getMessage());
        }
    }
}