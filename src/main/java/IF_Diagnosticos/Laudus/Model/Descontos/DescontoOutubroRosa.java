package IF_Diagnosticos.Laudus.Model.Descontos;

public class DescontoOutubroRosa extends DescontoDecorator {
    public DescontoOutubroRosa(Desconto desconto) {
        super(desconto);
    }

    @Override
    public double aplicarDesconto(double originalPrice) {
        double preco = super.aplicarDesconto(originalPrice);
        return preco * 0.95; // 5% de desconto
    }
}
