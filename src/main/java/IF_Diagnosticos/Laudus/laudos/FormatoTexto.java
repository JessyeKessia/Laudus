package IF_Diagnosticos.Laudus.laudos;

import IF_Diagnosticos.Laudus.exames.Exame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormatoTexto implements FormatoLaudo {
    @Override
    public void gerarLaudo(Exame exame) {

        // nome do arquivo salvo
        String nomeArquivo = exame.getPaciente().getNome();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo + ".txt"))) {

            // Cabeçalho
            String cabecalho = "Exame Nº: " + exame.getIdExame() + "\n" +
                    "Paciente: " + exame.getPaciente().getNome() + "\n" +
                    "Médico Solicitante: " + exame.getMedicoSolicitante().getNome() + "\n" +
                    "Data: " + exame.getData() + "\n";

            //corpo
            String corpo = exame.getDadosResultantes();

            // Rodapé
            String rodape = "Médico Responsável: " + exame.getMedicoResponsavel().getNome();

            // Montando o laudo
            writer.write("===================================\n");
            writer.write("          IF Diagnósticos          \n");
            writer.write("===================================\n\n");

            writer.write(cabecalho + "\n");
            writer.write(corpo + "\n\n");
            writer.write("-----------------------------------\n");
            writer.write(rodape + "\n");
            writer.write("===================================\n");

            System.out.println("[OK] Laudo gerado em TXT: " + nomeArquivo + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
