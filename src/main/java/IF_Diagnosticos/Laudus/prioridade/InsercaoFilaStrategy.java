
package IF_Diagnosticos.Laudus.prioridade;

import java.util.Deque;
import IF_Diagnosticos.Laudus.factory.Exame;

public interface InsercaoFilaStrategy {
    void inserir(Deque<Exame> fila, Exame exame);
}
