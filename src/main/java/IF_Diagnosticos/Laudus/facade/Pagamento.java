package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.desconto.*;
import IF_Diagnosticos.Laudus.factory.Exame;
import IF_Diagnosticos.Laudus.pagamento.ContextoPagamento;
import IF_Diagnosticos.Laudus.desconto.DescontoConvenioFactory;
import IF_Diagnosticos.Laudus.desconto.ExameDescontoIdoso;
import IF_Diagnosticos.Laudus.desconto.ExameDescontoOutubroRosa;

import java.util.ArrayList;
import java.util.List;

public class Pagamento {
    public boolean processarPagamento(Exame exame, boolean aplicarOutubroRosa) {
        
        // Aplica descontos via Decorator
        Exame exameDecorado = exame;
        // ve se não ta null o convenio e vai no factory pra pegar os descontos por tipo
        if (exame.getPaciente().getConvenio() != null && !exame.getPaciente().getConvenio().isBlank())
            exameDecorado = DescontoConvenioFactory.criarDescontoConvenio(exameDecorado);
        if (exame.getPaciente().isIdoso())
            exameDecorado = new ExameDescontoIdoso(exameDecorado);
        if (aplicarOutubroRosa)
            exameDecorado = new ExameDescontoOutubroRosa(exameDecorado);

        // Processa pagamento
        ContextoPagamento contexto = new ContextoPagamento(exameDecorado);
        boolean ok = contexto.processarPagamento();
        // Atualiza estado do pagamento no exame original
        exame.setEstadoPagamento(contexto.getExame().getEstadoPagamento());
        return ok;
    }
}
