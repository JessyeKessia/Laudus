
package IF_Diagnosticos.Laudus.pagamento;

public class PagamentoRecusado implements EstadoPagamento {
    public boolean lidarPagamento(ContextoPagamento contexto){
        System.out.println("Pagamento recusado, tente novamente.");
        return false;
    }
}
