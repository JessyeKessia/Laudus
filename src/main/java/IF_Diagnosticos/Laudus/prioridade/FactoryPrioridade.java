package IF_Diagnosticos.Laudus.prioridade;

public class FactoryPrioridade {
    public static InsercaoFilaStrategy getEstrategia(Prioridade prioridade) {
        return switch (prioridade) {
            case URGENTE -> new InsercaoUrgente();
            case POUCO_URGENTE -> new InsercaoPoucoUrgente();
            case ROTINA -> new InsercaoRotina();
        };
    }
}
