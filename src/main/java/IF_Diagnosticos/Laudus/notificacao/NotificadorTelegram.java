
package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;

public class NotificadorTelegram implements ObservadorNotificacao {
    private FachadaNotificacaoComunicacao fachada;
    public NotificadorTelegram(FachadaNotificacaoComunicacao fachada){ this.fachada = fachada; }
    public void atualizar(Paciente paciente, String mensagem){ fachada.enviarTelegram(paciente, mensagem); }
}
