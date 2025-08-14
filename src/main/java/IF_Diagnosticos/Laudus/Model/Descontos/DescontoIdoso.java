package IF_Diagnosticos.Laudus.Model.Descontos;

public class DescontoIdoso extends DescontoDecorator {
    public DescontoIdoso(Desconto desconto) {
        super(desconto);
    }

    @Override
    public double aplicarDesconto(double originalPrice) {
        double preco = super.aplicarDesconto(originalPrice);
        return preco * 0.85; // 15% de desconto
    }
}