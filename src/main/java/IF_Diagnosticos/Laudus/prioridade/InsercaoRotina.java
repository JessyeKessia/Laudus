package IF_Diagnosticos.Laudus.prioridade;

import IF_Diagnosticos.Laudus.exames.Exame;

import java.util.Deque;

public class InsercaoRotina implements InsercaoFilaStrategy {
    public void inserir(Deque<Exame> fila, Exame exame) {
        fila.addLast(exame);
    }
}
