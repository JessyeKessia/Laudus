
package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;

public interface ObservadorNotificacao {
    void atualizar(Paciente paciente, String mensagem);
}
