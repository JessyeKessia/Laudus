package IF_Diagnosticos.Laudus.Model.Pagamento;
import java.util.List;
import IF_Diagnosticos.Laudus.Model.Descontos.Desconto;

public class ContextoPagamento {
    private EstadoPagamento estado;
    private double valorTotal;

    public ContextoPagamento(double valorTotal) {
        this.valorTotal = valorTotal;
        this.estado = new PagamentoPendente();
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public boolean processarPagamento() {
        return estado.lidarPagamento(this);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valor) {
        this.valorTotal = valor;
    }

    public void aplicarDescontos(List<Desconto> descontosAplicar) {
        double valorComDescontos = valorTotal;
        for (Desconto desconto : descontosAplicar) {
            valorComDescontos = desconto.aplicarDesconto(valorComDescontos);
        }
        this.valorTotal = valorComDescontos;
    }
}
