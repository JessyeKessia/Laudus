package IF_Diagnosticos.Laudus.Model.Notificacao;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

public interface ObservadorNotificacao {
    void atualizar(Paciente paciente, String mensagem);
}
