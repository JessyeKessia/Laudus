package IF_Diagnosticos.Laudus.Model.Pagamento;

public class PagamentoAprovado implements EstadoPagamento {
    @Override
    public boolean lidarPagamento(ContextoPagamento contexto) {
        System.out.println("Pagamento aprovado no valor de: R$ " + contexto.getValorTotal());
        return true;
    }
}
