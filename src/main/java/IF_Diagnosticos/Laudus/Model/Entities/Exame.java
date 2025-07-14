package IF_Diagnosticos.Laudus.Model.Entities;

import IF_Diagnosticos.Laudus.Model.FormatoLaudo.FormatoLaudo;

import java.time.LocalDate;

public class Exame {
    protected FormatoLaudo formato;
    private static int sequencialGlobal = 1;
    private int numero;
    private Paciente paciente;
    private Medico medicoSolicitante;
    private String tipo;
    private LocalDate data;

    public Exame(Paciente paciente, Medico medicoSolicitante, FormatoLaudo formato, String tipo) {
        this.paciente = paciente;
        this.medicoSolicitante = medicoSolicitante;
        this.formato = formato;
        this.tipo = tipo;
        this.data = LocalDate.now();
        this.numero = sequencialGlobal++;
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedicoSolicitante() { return medicoSolicitante; }
    public String getTipo() { return tipo; }
    public LocalDate getData() { return data; }

    public String getCabecalho() {
        return "Exame Nº: " + numero + "\n" +
                "Paciente: " + paciente.getNome() + "\n" +
                "Convênio: " + (paciente.getConvenio()) + "\n" +
                "Médico Solicitante: " + medicoSolicitante.getNome() + "\n" +
                "Data: " + data;
    }

}