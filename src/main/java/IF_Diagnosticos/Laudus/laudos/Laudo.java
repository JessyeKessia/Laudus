package IF_Diagnosticos.Laudus.laudos;

import IF_Diagnosticos.Laudus.Model.entities.Medico;
import IF_Diagnosticos.Laudus.Model.entities.Paciente;
import IF_Diagnosticos.Laudus.formatoLaudo.FormatoLaudo;
import IF_Diagnosticos.Laudus.Model.entities.Exame;

import java.time.LocalDate;


public abstract class Laudo {
    protected FormatoLaudo formato;

    public Laudo(FormatoLaudo formato) {
        this.formato = formato;
    }

    public void gerar(Exame exame, Medico laudista) {
        String nomeArquivo = gerarNomeArquivo(exame.getPaciente(), exame);
        String cabecalho = exame.getCabecalho();
        String corpo = gerarCorpo(exame);
        String rodape = "Médico Responsável: " + laudista.getNome() + " " + laudista.getCrm();
        formato.gerarLaudo(cabecalho, corpo, rodape, nomeArquivo);
    }

    protected abstract String gerarCorpo(Exame exame);

    protected String gerarNomeArquivo(Paciente paciente, Exame exame) {
        String exame_nome = exame.getTipo().toLowerCase().replace(" ", "_");
        String nome = paciente.getNome().toLowerCase().replace(" ", "_");
        String data = LocalDate.now().toString();
        return "laudo_" + exame_nome + "_" + nome + "_" + data;
    }
}
