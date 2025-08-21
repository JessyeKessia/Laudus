package IF_Diagnosticos.Laudus.brigde;

import IF_Diagnosticos.Laudus.entities.Convenio;
import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;

public class FormatoPDF implements FormatoLaudo {
    public String formatarCabecalho(Paciente paciente, Medico medico, Convenio cconvenio) {return "PDF"; }
    public String formatarCorpo(String dadosResultantes) { return "PDF"; }
    public String formatarRodape(Medico medico) { return "PDF"; }

    public void renderizarPDF(String dadosResultantes, Paciente paciente, Medico medico, Convenio convenio, Medico medicoResponsavel) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("laudo.pdf"));
            doc.open();
            doc.add(new Paragraph("Laudo ST Diagnósticos"));
            doc.add(new Paragraph("Paciente: " + paciente.getNome())); doc.add(new Paragraph("Conteúdo:\n" + dadosResultantes));
            doc.add(new Paragraph("Responsável: " + medicoResponsavel.getNome())); doc.close();

            System.out.println("PDF gerado em: laudo.pdf");

        } catch (Exception e) {
            System.err.println("Erro ao gerar PDF: " + e.getMessage());
        }
    }
}

