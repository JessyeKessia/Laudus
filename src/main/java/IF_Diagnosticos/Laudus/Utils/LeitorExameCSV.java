package IF_Diagnosticos.Laudus.Utils;

import IF_Diagnosticos.Laudus.Model.Entities.Exame;
import IF_Diagnosticos.Laudus.Model.Entities.Medico;
import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorExameCSV {
    public static List<Exame> ler(String caminhoCSV) {
        List<Exame> exames = new ArrayList<>();
        System.out.println(" oi leu");

        try (CSVReader reader = new CSVReader(new FileReader(caminhoCSV))) {
            String[] linha;
            reader.readNext(); // pula cabeçalho
            System.out.println(" oi leu22");

            while ((linha = reader.readNext()) != null) {
                if (linha.length < 9) continue;
                System.out.println(" oi leu33");

                String nomePaciente = linha[0].trim();
                System.out.println(linha[0].trim());
                String convenio = linha[1].trim();
                String nomeSolicitante = linha[2].trim();
                String crnSolicitante = linha[3].trim();
                String nomeResponsavel = linha[4].trim();
                String crnResponsavel = linha[5].trim();
                String tipoExame = linha[6].trim();
                String especialidade = linha[7].trim();
                String resultados = linha[8].trim();

                Paciente paciente = new Paciente(nomePaciente, convenio);
                Medico solicitante = new Medico(nomeSolicitante, crnSolicitante);
                Medico responsavel = new Medico(nomeResponsavel, crnResponsavel);

                Exame exame = new Exame(paciente, solicitante, responsavel, tipoExame, resultados, especialidade);
                exame.setEspecialidade(especialidade);

                exames.add(exame);
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler o CSV de exames:");
            e.printStackTrace();
        }

        return exames;
    }
}
