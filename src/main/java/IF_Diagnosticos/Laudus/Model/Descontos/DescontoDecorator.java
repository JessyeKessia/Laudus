package IF_Diagnosticos.Laudus.Model.Descontos;

public abstract class DescontoDecorator implements Desconto {
    protected Desconto desconto;

    public DescontoDecorator(Desconto desconto) {
        this.desconto = desconto;
    }

    @Override
    public double aplicarDesconto(double originalPrice) {
        return desconto.aplicarDesconto(originalPrice);
    }
}
