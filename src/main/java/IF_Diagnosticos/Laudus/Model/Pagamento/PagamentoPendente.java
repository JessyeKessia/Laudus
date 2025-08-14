package IF_Diagnosticos.Laudus.Model.Pagamento;

public class PagamentoPendente implements EstadoPagamento {
    @Override
    public boolean lidarPagamento(ContextoPagamento contexto) {
        System.out.println("Processando pagamento pendente...");
        if (contexto.getValorTotal() > 0) {
            contexto.setEstado(new PagamentoAprovado());
            return true;
        } else {
            contexto.setEstado(new PagamentoRecusado());
            return false;
        }
    }
}
