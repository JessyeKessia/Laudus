package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.facade.FachadaNotificacaoComunicacao;

import java.io.File;

public class NotificadorTelegram implements ObservadorNotificacao {
    private final FachadaNotificacaoComunicacao fachada;

    public NotificadorTelegram(FachadaNotificacaoComunicacao fachada) {
        this.fachada = fachada;
    }

    @Override
    public void atualizar(Paciente paciente, String mensagem, File anexo) {
        fachada.enviarTelegram(paciente, mensagem);
    }
}