package IF_Diagnosticos.Laudus.pagamento;

public class PagamentoAprovado implements EstadoPagamento {
    
    @Override
    public boolean lidarPagamento(ContextoPagamento contexto) {
        System.out.println("✅ [ESTADO FINAL]: Pagamento APROVADO no valor de: R$ " + String.format("%.2f", contexto.getValorTotal()));
        return true;
    }
}
