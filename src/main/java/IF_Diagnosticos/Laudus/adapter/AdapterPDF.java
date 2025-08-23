package IF_Diagnosticos.Laudus.adapter;

import IF_Diagnosticos.Laudus.bridge.Exame;
import IF_Diagnosticos.Laudus.bridge.FormatoTexto;
import IF_Diagnosticos.Laudus.entidades.Medico;

public class AdapterPDF implements Laudo {

    private final Laudo formatoTexto = new FormatoTexto(); // Target Interface
    private final GeradorPDFService service = new GeradorPDFService(); // Adaptee

    public void formatarLaudo(Exame exame, String conteudo, Medico medicoResponsavel) {
        // Monta o conteúdo do laudo em formato texto
        StringBuilder sb = new StringBuilder();
        sb.append("===== LAUDO MÉDICO =====\n\n");
        sb.append("Paciente: ").append(exame.getPaciente().getNome()).append("\n");
        sb.append("Exame: ").append(exame.getTipo()).append("\n");
        sb.append("Convênio: ").append(exame.getPaciente().getConvenio()).append("\n");
        sb.append("Data: ").append(exame.getData()).append("\n");
        sb.append("Idade: ").append(exame.getPaciente().getIdade()).append(" anos\n\n");

        sb.append(">>> RESULTADO <<<\n");
        sb.append(conteudo).append("\n\n");

        sb.append("Médico Responsável: ").append(medicoResponsavel.getNome())
                .append(" - CRM: ").append(medicoResponsavel.getCrm()).append("\n");

        String textoCompleto = sb.toString();

        // Gera o PDF de fato
        String nomeArquivo = "laudo_" + exame.getTipo().replaceAll("\\s+", "_") + ".pdf";
        service.gerarPDF(textoCompleto, nomeArquivo);

    }
}