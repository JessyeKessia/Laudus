
package IF_Diagnosticos.Laudus.prioridade;

import java.util.Deque;
import java.util.LinkedList;
import IF_Diagnosticos.Laudus.factory.Exame;

public class InsercaoPoucoUrgente implements InsercaoFilaStrategy {
    public void inserir(Deque<Exame> fila, Exame exame) {
        int pos = 0;
        for (Exame e : fila) {
            if (e.getPrioridade() == Prioridade.URGENTE) pos++;
            else break;
        }
        ((LinkedList<Exame>)fila).add(pos, exame);
    }
}
