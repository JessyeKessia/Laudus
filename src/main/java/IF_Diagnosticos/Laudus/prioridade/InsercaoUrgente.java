
package IF_Diagnosticos.Laudus.prioridade;

import java.util.Deque;
import IF_Diagnosticos.Laudus.factory.Exame;

public class InsercaoUrgente implements InsercaoFilaStrategy {
    public void inserir(Deque<Exame> fila, Exame exame) { fila.addFirst(exame); }
}
