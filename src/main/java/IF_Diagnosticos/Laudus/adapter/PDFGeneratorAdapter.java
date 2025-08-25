package IF_Diagnosticos.Laudus.adapter;

import IF_Diagnosticos.Laudus.bridge.FormatoLaudo;
import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;

public class PDFGeneratorAdapter implements FormatoLaudo {
    private PDFGenerator pdfService;

    public PDFGeneratorAdapter(PDFGenerator pdfService) {
        this.pdfService = pdfService;
    }

    @Override
    public File gerar(Exame exame, String conteudo) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== LAUDO MÉDICO =====\n\n");
        sb.append("Paciente: ").append(exame.getPaciente().getNome()).append("\n");
        sb.append("Exame: ").append(exame.getTipo()).append(" - ").append(exame.getPrioridade()).append("\n");
        sb.append("Convênio: ").append(exame.getPaciente().getConvenio()).append("\n");
        sb.append("Data: ").append(exame.getDataSolicitacao()).append("\n");
        sb.append("Idade: ").append(exame.getPaciente().getIdade()).append(" anos\n\n");
        sb.append(">>> RESULTADO <<<\n");
        sb.append(conteudo).append("\n\n");
        Medico m = exame.getMedico();
        sb.append("Médico Responsável: ").append(m.getNome()).append(" - CRM: ").append(m.getCrm()).append("\n");

        // Escreve o PDF via o serviço injetado - delega a responsabilidade de I/O
        File out = new File("laudos", "laudo_" + exame.getNumeroSequencial() + ".pdf");
        if (pdfService != null) {
            pdfService.gerarPDF(out.getAbsolutePath(), sb.toString());
        }
        return out;
    }
}
