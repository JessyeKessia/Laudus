package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.facade.FachadaNotificacaoComunicacao;

import java.io.File;

public class NotificadorEmail implements ObservadorNotificacao {
    private final FachadaNotificacaoComunicacao fachada;

    public NotificadorEmail(FachadaNotificacaoComunicacao fachada) {
        this.fachada = fachada;
    }

    @Override
    public void atualizar(Paciente paciente, String mensagem, File anexo) {
        fachada.enviarEmail(paciente, mensagem, anexo);
    }
}