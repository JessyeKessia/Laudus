package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.adapter.AdapterPDF;
import IF_Diagnosticos.Laudus.bridge.*;
import IF_Diagnosticos.Laudus.entidades.Medico;

import java.io.FileWriter;
import java.io.IOException;

public class EmissorLaudo {
    public String emitirLaudo(Exame exame, String conteudo, Medico medicoResponsavel) {
        LaudoFormato formato;

        switch (exame.toUpperCase()) {
            case "TEXTO":
                formato = new FormatoTexto();
                break;
            case "HTML":
                formato = new FormatoHTML();
                break;
            default:
                AdapterPDF adapterPDF = new AdapterPDF(); // cria instância
                adapterPDF.gerarPDF(exame, conteudo, medicoResponsavel); // gera PDF com adapter
                return null;
        }

        Exame exame = new Exame(formato);
        String laudoConteudo = laudo.gerar(exame, paciente, medicoSolicitante, conteudo, medicoResponsavel);

        // Fazendo a emissão
        String nomeArquivo;

        if (tipoFormato.equalsIgnoreCase("HTML")) {
            nomeArquivo = "/emissoes" + "laudo_" + exame.getTipo().replaceAll("\\s+", "_") + ".html";
        } else { // TXT
            nomeArquivo = "/emissoes" + "laudo_" + exame.getTipo().replaceAll("\\s+", "_") + ".txt";
        }

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(laudoConteudo);
            System.out.println("Laudo gerado com sucesso em: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
