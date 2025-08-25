package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.desconto.DescontoConvenioFactory;
import IF_Diagnosticos.Laudus.desconto.ExameDescontoIdoso;
import IF_Diagnosticos.Laudus.desconto.ExameDescontoOutubroRosa;
import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;
import IF_Diagnosticos.Laudus.pagamento.ContextoPagamento;

public class Pagamento {

    public boolean processarPagamento(Exame exame, boolean aplicarOutubroRosa) {
        System.out.println("\n--- INICIANDO PROCESSAMENTO DE PAGAMENTO PARA: " + exame.getPaciente().getNome() + " ---");


        if (exame instanceof ExameLaboratorial lab && lab.getValorMedido() < 0) {
            System.out.println("❌ ERRO: O resultado do exame (" + lab.getValorMedido() + ") é inválido. Pagamento não pode ser processado.");
            System.out.println("--- FIM DO PROCESSAMENTO DE PAGAMENTO ---");
            return false; 
        }

        System.out.println("Valor base do exame (" + exame.getTipo() + "): R$ " + String.format("%.2f", exame.getValorBase()));

        Exame exameDecorado = exame;
        
        if (exame.getPaciente().getConvenio() != null && !exame.getPaciente().getConvenio().isBlank()) {
            System.out.println("Aplicando desconto de convênio: " + exame.getPaciente().getConvenio());
            exameDecorado = DescontoConvenioFactory.criarDescontoConvenio(exameDecorado);
        }
        if (exame.getPaciente().isIdoso()) {
            System.out.println("Aplicando desconto para idoso...");
            exameDecorado = new ExameDescontoIdoso(exameDecorado);
        }
        if (aplicarOutubroRosa) {
            System.out.println("Aplicando desconto da campanha Outubro Rosa...");
            exameDecorado = new ExameDescontoOutubroRosa(exameDecorado);
        }

        ContextoPagamento contexto = new ContextoPagamento(exameDecorado);
        System.out.println("Valor final com descontos: R$ " + String.format("%.2f", contexto.getValorTotal()));
        System.out.println("[ESTADO INICIAL]: Pagamento Pendente");

        boolean pagamentoOk = contexto.processarPagamento();
        
        System.out.println("--- FIM DO PROCESSAMENTO DE PAGAMENTO ---");
        return pagamentoOk;
    }
}
