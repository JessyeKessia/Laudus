package IF_Diagnosticos.Laudus.Model.Notificacao;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

public class NotificadorEmail implements ObservadorNotificacao {
    private FachadaNotificacaoComunicacao fachadaComunicacao;

    public NotificadorEmail(FachadaNotificacaoComunicacao fachada) {
        this.fachadaComunicacao = fachada;
    }

    public void atualizar(Paciente paciente, String mensagem) {
        fachadaComunicacao.enviarEmail(paciente, mensagem);
    }
}

