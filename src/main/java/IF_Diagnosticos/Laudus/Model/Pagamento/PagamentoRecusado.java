package IF_Diagnosticos.Laudus.Model.Pagamento;

public class PagamentoRecusado implements EstadoPagamento {
    @Override
    public boolean lidarPagamento(ContextoPagamento contexto) {
        System.out.println("Pagamento recusado, tente novamente");
        return false;
    }
}
