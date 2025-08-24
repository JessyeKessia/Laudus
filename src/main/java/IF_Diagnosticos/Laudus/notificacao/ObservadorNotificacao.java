package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;
import java.io.File;

public interface ObservadorNotificacao {
    void atualizar(Paciente paciente, String mensagem, File anexo);
}