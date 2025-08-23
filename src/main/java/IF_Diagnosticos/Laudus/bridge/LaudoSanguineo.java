package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class LaudoSanguineo extends Laudo {
    public LaudoSanguineo(LaudoFormato formatador, Exame exame, String conteudo) {
        super(exame, formatador, conteudo);
    }
    public String renderizar() {
        return formatador.formatarLaudo(formatador, exame, conteudo);
    }
}
