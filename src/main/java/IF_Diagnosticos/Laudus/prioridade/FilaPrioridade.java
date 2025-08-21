package IF_Diagnosticos.Laudus.prioridade;

import IF_Diagnosticos.Laudus.brigde.Exame;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FilaPrioridade {
    // cria a fila
    private Deque<Exame> fila = new LinkedList<>();

    // adicionar exame na fila
    public void adicionarExame(Exame exame) {
        InsercaoFilaStrategy estrategia = FactoryPrioridade.getEstrategia(exame.getPrioridade());
        estrategia.inserir(fila, exame);
    }

    public Exame processarProximo() {
        return fila.pollFirst(); // remove e retorna o exame do início da fila
    }

    public List<Exame> listarFila() {
        return new ArrayList<>(fila);
    }
}

