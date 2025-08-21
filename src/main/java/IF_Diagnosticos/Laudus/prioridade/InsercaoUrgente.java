package IF_Diagnosticos.Laudus.prioridade;

import IF_Diagnosticos.Laudus.brigde.Exame;

import java.util.Deque;

public class InsercaoUrgente implements InsercaoFilaStrategy {
    public void inserir(Deque<Exame> fila, Exame exame) {
        fila.addFirst(exame);
    }
}
