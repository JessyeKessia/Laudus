package IF_Diagnosticos.Laudus.Model.Notificacao;

import java.util.ArrayList;
import java.util.List;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

public class AssuntoNotificacao {
    private List<ObservadorNotificacao> observadores = new ArrayList<>();

    public void adicionarObservador(ObservadorNotificacao observador) {
        observadores.add(observador);
    }

    public void removerObservador(ObservadorNotificacao observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(Paciente paciente, String mensagem) {
        for (ObservadorNotificacao observador : observadores) {
            observador.atualizar(paciente, mensagem);
        }
    }
}

