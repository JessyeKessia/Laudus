
package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;

public class FachadaNotificacaoComunicacao {
    public void enviarEmail(Paciente p, String mensagem){
        System.out.println("[EMAIL] Para: " + p.getEmail() + " -> " + mensagem);
    }
    public void enviarTelegram(Paciente p, String mensagem){
        System.out.println("[TELEGRAM] Para: " + p.getNome() + " (" + p.getTelefone() + ") -> " + mensagem);
    }
}
