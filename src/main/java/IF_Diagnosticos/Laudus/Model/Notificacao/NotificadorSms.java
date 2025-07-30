package IF_Diagnosticos.Laudus.Model.Notificacao;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

public class NotificadorSms implements ObservadorNotificacao {
    private FachadaNotificacaoComunicacao fachadaComunicacao;

    public NotificadorSms(FachadaNotificacaoComunicacao fachada) {
        this.fachadaComunicacao = fachada;
    }

    public void atualizar(Paciente paciente, String mensagem) {
        fachadaComunicacao.enviarSMS(paciente, mensagem);
    }
}
