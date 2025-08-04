package IF_Diagnosticos.Laudus.Model.Notificacao;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;
import IF_Diagnosticos.Laudus.Model.Facate.FachadaNotificacaoComunicacao;

public class NotificadorTelegram implements ObservadorNotificacao {
    private FachadaNotificacaoComunicacao fachada;

    public NotificadorTelegram(FachadaNotificacaoComunicacao fachada) {
        this.fachada = fachada;
    }

    @Override
    public void atualizar(Paciente paciente, String mensagem) {
        fachada.enviarTelegram(paciente, mensagem);
    }
}

