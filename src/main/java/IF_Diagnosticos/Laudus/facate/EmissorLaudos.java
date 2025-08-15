package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.exames.Exame;
import IF_Diagnosticos.Laudus.laudos.FormatoLaudo;
import IF_Diagnosticos.Laudus.laudos.FormatoPDF;
import IF_Diagnosticos.Laudus.laudos.FormatoHTML;
import IF_Diagnosticos.Laudus.laudos.FormatoTexto;
import IF_Diagnosticos.Laudus.exames.ExameSanguineo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmissorLaudos {
    private List<Exame> examesCarregados;

    public EmissorLaudos(List<Exame> examesCarregados) {
        this.examesCarregados = examesCarregados;
    }

    public void emitirLaudo(String nomeBuscado, String formatoStr) {
        List<Exame> examesDoPaciente = examesCarregados.stream()
                .filter(e -> e.getPaciente().getNome().equalsIgnoreCase(nomeBuscado))
                .collect(Collectors.toCollection(ArrayList::new));

        if (examesDoPaciente.isEmpty()) {
            System.out.println("❌ Paciente não encontrado ou sem exames registrados com este nome.");
            return;
        }
        FormatoLaudo formatoEscolhido = switch (formatoStr.toLowerCase()) {
            case "texto" -> new FormatoTexto();
            case "html" -> new FormatoHTML();
            case "pdf" -> new FormatoPDF();
            default -> throw new IllegalArgumentException("❌ Formato inválido: " + formatoStr + ". Use: texto, html ou pdf.");
        };

        System.out.println("\n--- Gerando Laudos para " + examesDoPaciente.get(0).getPaciente().getNome() + " ---");

        for (Exame exame : examesDoPaciente) {
            System.out.println("Processando Exame Nº " + exame.getNumeroIdentificacao() + " (" + exame.getTipo() + ")");

            FormatoLaudo laudo = switch (exame.getTipo().toLowerCase()) {
                case "hemograma" -> new LaudoHemograma(formatoEscolhido);
                case "ultrassonografia abdominal" -> new LaudoUltrassonografia(formatoEscolhido);
                case "ressonância magnética joelho" -> new ExameSanguineo(formatoEscolhido);
                case "exame de urina" -> new LaudoHemograma(formatoEscolhido);
                default -> throw new IllegalArgumentException("Tipo de exame não suportado: " + exame.getTipo());
            };

            laudo.gerar(exame, exame.getMedicoResponsavel());

            System.out.println("✅ Laudo em formato " + formatoStr + " gerado para " + exame.getPaciente().getNome()
                    + " (Exame Nº " + exame.getNumeroIdentificacao() + ").");
            System.out.println("----------------------------------------");

            System.out.println("✅ Laudo em formato " + formatoEscolhido.getClass().getSimpleName().replace("Formato", "") +
                    " gerado para " + exame.getPaciente().getNome() + " (Exame Nº " + exame.getNumeroIdentificacao() + ").");
            System.out.println("----------------------------------------");
        }
    }
}
