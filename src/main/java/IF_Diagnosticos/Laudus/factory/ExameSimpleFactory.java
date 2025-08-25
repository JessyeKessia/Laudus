package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameSimpleFactory {
    
    public static Exame criarExameLaboratorial(Paciente paciente, Medico solicitante, Prioridade prioridade, String tipo, double valorMedido, String unidade) {
        return new ExameLaboratorial(paciente, solicitante, solicitante, prioridade, tipo, valorMedido, unidade);
    }

    public static Exame criarExameRaioX(Paciente paciente, Medico solicitante, Prioridade prioridade, String regiao, String imagem) {
        return new ExameRaioX(paciente, solicitante, solicitante, prioridade, regiao, imagem);
    }

    public static Exame criarExameRessonancia(Paciente paciente, Medico solicitante, Prioridade prioridade, String regiao,
                                              boolean utilizouContraste, String tipoContraste, double dosagemContraste,
                                              boolean possuiMarcapasso, boolean possuiImplantesMetalicos) {
        return new ExameRessonancia(paciente, solicitante, solicitante, prioridade, regiao, utilizouContraste, tipoContraste, dosagemContraste, possuiMarcapasso, possuiImplantesMetalicos);
    }
}
