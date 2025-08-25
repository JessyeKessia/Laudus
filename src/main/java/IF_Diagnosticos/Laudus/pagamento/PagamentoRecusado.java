package IF_Diagnosticos.Laudus.pagamento;

public class PagamentoRecusado implements EstadoPagamento {
    
    @Override
    public boolean lidarPagamento(ContextoPagamento contexto) {
        System.out.println("❌ [ESTADO FINAL]: Pagamento RECUSADO. Valor: R$ " + String.format("%.2f", contexto.getValorTotal()));
        return false;
    }
}
