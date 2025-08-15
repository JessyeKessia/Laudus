package IF_Diagnosticos.Laudus.prioridade;

import IF_Diagnosticos.Laudus.exames.Exame;
import java.util.Deque;

public interface InsercaoFilaStrategy {
    void inserir(Deque<Exame> fila, Exame exame);
}
