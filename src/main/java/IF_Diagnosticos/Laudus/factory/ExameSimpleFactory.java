package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameSimpleFactory {
    
    public static Exame criarExameLaboratorial(Paciente paciente, Medico solicitante, Prioridade prioridade, String tipo, double valorMedido, String unidade) {
        // A CORREÇÃO CRÍTICA:
        // Agora passamos 'valorMedido' como o último argumento, que será usado
        // como o preço (valorBase) do exame.
        return new ExameLaboratorial(paciente, solicitante, solicitante, prioridade, tipo, valorMedido, unidade, valorMedido);
    }

    public static Exame criarExameRaioX(Paciente paciente, Medico solicitante, Prioridade prioridade, String regiao, String imagem) {
        // Assumindo que o construtor de ExameRaioX não precisa de alterações.
        // Se precisar, a lógica seria similar à do ExameLaboratorial.
        return new ExameRaioX(paciente, solicitante, solicitante, prioridade, regiao, imagem);
    }

    public static Exame criarExameRessonancia(Paciente paciente, Medico solicitante, Prioridade prioridade, String regiao,
                                              boolean utilizouContraste, String tipoContraste, double dosagemContraste,
                                              boolean possuiMarcapasso, boolean possuiImplantesMetalicos) {
        // Assumindo que o construtor de ExameRessonancia não precisa de alterações.
        return new ExameRessonancia(paciente, solicitante, solicitante, prioridade, regiao, utilizouContraste, tipoContraste, dosagemContraste, possuiMarcapasso, possuiImplantesMetalicos);
    }
}
