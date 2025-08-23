package IF_Diagnosticos.Laudus.desconto;

public class DescontoConvenio extends DescontoDecorator {
    public DescontoConvenio(Preco preco) {
        super(preco);
    }

    public double getPreco() {
        double preco = super.aplicarDesconto(originalPrice);
        return preco * 0.90; // 10% de desconto
    }
}