package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;
import java.io.File;

public class NotificadorTelegram implements ObservadorNotificacao {
    private final FachadaNotificacaoComunicacao fachada;

    public NotificadorTelegram(FachadaNotificacaoComunicacao fachada) {
        this.fachada = fachada;
    }

    @Override
    public void atualizar(Paciente paciente, String mensagem, File anexo) {
        // A lógica do Telegram ignora o anexo por enquanto.
        fachada.enviarTelegram(paciente, mensagem);
    }
}