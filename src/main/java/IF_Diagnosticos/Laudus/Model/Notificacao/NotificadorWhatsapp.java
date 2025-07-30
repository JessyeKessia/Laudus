package IF_Diagnosticos.Laudus.Model.Notificacao;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

public class NotificadorWhatsapp implements ObservadorNotificacao {
    private FachadaNotificacaoComunicacao fachadaComunicacao;

    public NotificadorWhatsapp(FachadaNotificacaoComunicacao fachada) {
        this.fachadaComunicacao = fachada;
    }

    public void atualizar(Paciente paciente, String mensagem) {
        fachadaComunicacao.enviarWhatsapp(paciente, mensagem);
    }
}

