
package IF_Diagnosticos.Laudus.notificacao;

import java.util.ArrayList;
import java.util.List;
import IF_Diagnosticos.Laudus.entidades.Paciente;

public class AssuntoNotificacao {
    private List<ObservadorNotificacao> observadores = new ArrayList<>();
    public void adicionarObservador(ObservadorNotificacao o){ observadores.add(o); }
    public void removerObservador(ObservadorNotificacao o){ observadores.remove(o); }
    public void notificar(Paciente p, String mensagem){
        for (ObservadorNotificacao o : observadores) { o.atualizar(p, mensagem); }
    }
}
