
package IF_Diagnosticos.Laudus.pagamento;

public class PagamentoPendente implements EstadoPagamento {
    public boolean lidarPagamento(ContextoPagamento contexto){
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
