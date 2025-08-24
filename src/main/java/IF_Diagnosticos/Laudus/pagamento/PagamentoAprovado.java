
package IF_Diagnosticos.Laudus.pagamento;

public class PagamentoAprovado implements EstadoPagamento {
    public boolean lidarPagamento(ContextoPagamento contexto){
        System.out.println("Pagamento aprovado no valor de: R$ " + String.format("%.2f", contexto.getValorTotal()));
        return true;
    }
}
