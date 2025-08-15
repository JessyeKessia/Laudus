package IF_Diagnosticos.Laudus.laudos;

import IF_Diagnosticos.Laudus.exames.Exame;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;

public class FormatoPDF implements FormatoLaudo {
    public void gerarLaudo(Exame exame) {
        try {
            // Nome do arquivo
            String nomeArquivo = exame.getPaciente().getNome();

            // criando o arquivo
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(nomeArquivo + ".pdf"));

            // abrindo o documento PDF para edição
            doc.open();

            // Adicionando a logo
            String caminhoLogo = "src/main/java/IF_Diagnosticos/Laudus/logo/OIG1.jpg";
            if (caminhoLogo != null && !caminhoLogo.isEmpty()) {
                Image logo = Image.getInstance(caminhoLogo);
                logo.scaleToFit(100, 100); // ajusta o tamanho da imagem
                logo.setAlignment(Image.ALIGN_CENTER); // centraliza
                doc.add(logo);
            }

            // Cabeçalho
            String cabecalho = "Exame Nº: " + exame.getIdExame() + "\n" +
                    "Paciente: " + exame.getPaciente().getNome() + "\n" +
                    "Médico Solicitante: " + exame.getMedicoSolicitante().getNome() + "\n" +
                    "Data: " + exame.getData();

            // Corpo
            String corpo = exame.getDadosResultantes();

            // Rodapé
            String rodape = "Médico Responsável: " + exame.getMedicoResponsavel().getNome();

            // Fontes
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font corpoFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font rodapeFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12);

            // Adicionando texto
            doc.add(new Paragraph("\nIF Diagnósticos", tituloFont));
            doc.add(new Paragraph("\n")); // linha em branco
            doc.add(new Paragraph(cabecalho, corpoFont));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph(corpo, corpoFont));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph(rodape, rodapeFont));

            doc.close();

            System.out.println("[OK] Laudo gerado em PDF: " + nomeArquivo + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

