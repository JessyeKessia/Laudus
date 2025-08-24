
package IF_Diagnosticos.Laudus.prioridade;

import java.util.*;
import IF_Diagnosticos.Laudus.factory.Exame;

public class FilaPrioridade {
    private Deque<Exame> fila = new LinkedList<>();

    public void adicionarExame(Exame exame){
        InsercaoFilaStrategy estrategia = FactoryPrioridade.getEstrategia(exame.getPrioridade());
        estrategia.inserir(fila, exame);
    }
    public Exame processarProximo(){ return fila.pollFirst(); }
    public List<Exame> listarFila(){ return new ArrayList<>(fila); }
}
