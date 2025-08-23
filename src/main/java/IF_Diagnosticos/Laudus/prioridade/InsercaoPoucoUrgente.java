package IF_Diagnosticos.Laudus.prioridade;


import IF_Diagnosticos.Laudus.bridge.Exame;

import java.util.Deque;
import java.util.LinkedList;

public class InsercaoPoucoUrgente implements InsercaoFilaStrategy {
    public void inserir(Deque<Exame> fila, Exame exame) {
        int pos = 0;
        for (Exame e : fila) {
            if (e.getPrioridade() == Prioridade.URGENTE) pos++;
            else break;
        }
        ((LinkedList<Exame>) fila).add(pos, exame);
    }
}
