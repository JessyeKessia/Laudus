package IF_Diagnosticos.Laudus.pagamento;

public class PagamentoPendente implements EstadoPagamento {
    
    @Override
    public boolean lidarPagamento(ContextoPagamento contexto) {
        System.out.println("Processando pagamento...");
        
        // Simula uma verificação de pagamento.
        // Valores >= 0 são considerados válidos (permitindo exames gratuitos com 100% de desconto).
        if (contexto.getValorTotal() >= 0) {
            System.out.println("Transição para -> Pagamento Aprovado");
            contexto.setEstado(new PagamentoAprovado());
        } else {
            System.out.println("Transição para -> Pagamento Recusado (Valor inválido)");
            contexto.setEstado(new PagamentoRecusado());
        }
        
        // DELEGA a chamada para o novo estado para finalizar o processo e obter o status.
        return contexto.processarPagamento();
    }
}
