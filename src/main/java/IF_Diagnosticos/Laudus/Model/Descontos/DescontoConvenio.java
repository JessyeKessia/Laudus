package IF_Diagnosticos.Laudus.Model.Descontos;

public class DescontoConvenio extends DescontoDecorator {
    public DescontoConvenio(Desconto desconto) {
        super(desconto);
    }

    @Override
    public double aplicarDesconto(double originalPrice) {
        double preco = super.aplicarDesconto(originalPrice);
        return preco * 0.90; // 10% de desconto
    }
}
