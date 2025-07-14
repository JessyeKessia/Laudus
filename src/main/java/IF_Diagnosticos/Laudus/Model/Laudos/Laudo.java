package IF_Diagnosticos.Laudus.Model.Laudos;

import IF_Diagnosticos.Laudus.Model.Entities.Medico;
import IF_Diagnosticos.Laudus.Model.Entities.Paciente;
import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoLaudo;
import IF_Diagnosticos.Laudus.Model.Entities.Exame;

import java.time.LocalDate;


public abstract class Laudo {
    protected FormatoLaudo formato;

    public Laudo(FormatoLaudo formato) {
        this.formato = formato;
    }

    public void gerar(Exame exame, Medico laudista) {
        String nomeArquivo = gerarNomeArquivo(exame.getPaciente(), exame);
        String cabecalho = exame.getCabecalho();
        String corpo = gerarCorpo();  // corpo definido por cada exame
        String rodape = "Médico Responsável: " + laudista.getAssinatura();
        formato.gerarLaudo(cabecalho, corpo, rodape, nomeArquivo);
    }

    protected abstract String gerarCorpo();

    protected String gerarNomeArquivo(Paciente paciente, Exame exame) {
        String exame = exame.getTipo().toLowerCase().replace(" ", "_");
        String nome = paciente.getNome().toLowerCase().replace(" ", "_");
        String data = LocalDate.now().toString();
        return "laudo_" + exame + "_" + nome + "_" + data;
    }
}
