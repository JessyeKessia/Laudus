
package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;

public class NotificadorEmail implements ObservadorNotificacao {
    private FachadaNotificacaoComunicacao fachada;
    public NotificadorEmail(FachadaNotificacaoComunicacao fachada){ this.fachada = fachada; }
    public void atualizar(Paciente paciente, String mensagem){ fachada.enviarEmail(paciente, mensagem); }
}
