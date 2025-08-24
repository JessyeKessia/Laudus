
package IF_Diagnosticos.Laudus.pagamento;

import IF_Diagnosticos.Laudus.factory.Exame;

public class ContextoPagamento {
    private EstadoPagamento estado;
    private double valorTotal;
    private Exame exame;

    public ContextoPagamento(Exame exame){
        this.exame = exame;
        this.valorTotal = exame.getValorBase();
        this.estado = new PagamentoPendente();
    }

    public void setEstado(EstadoPagamento estado){ this.estado = estado; }
    public boolean processarPagamento(){ return estado.lidarPagamento(this); }
    public double getValorTotal(){ return valorTotal; }
    public void setValorTotal(double v){ this.valorTotal = v; }

    public Exame getExame() { return exame; }
    public void setExame(Exame exame) {
        this.exame = exame;
        this.valorTotal = exame.getValorBase();
    }

    public void atualizarValor() {
        this.valorTotal = exame.getValorBase();
    }
}
