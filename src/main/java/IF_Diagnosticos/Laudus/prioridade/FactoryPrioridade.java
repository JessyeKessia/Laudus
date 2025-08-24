
package IF_Diagnosticos.Laudus.prioridade;

public class FactoryPrioridade {
    public static InsercaoFilaStrategy getEstrategia(Prioridade p) {
        return switch (p) {
            case URGENTE -> new InsercaoUrgente();
            case POUCO_URGENTE -> new InsercaoPoucoUrgente();
            case ROTINA -> new InsercaoRotina();
        };
    }
}
