package IF_Diagnosticos.Laudus.desconto;

public abstract class DescontoDecorator implements Preco {
    protected Preco precoDecorado; // O objeto Exame que está sendo decorado

    public DescontoDecorator(Preco preco) {
        this.precoDecorado = preco;
    }
    public double getPreco() {
        return precoDecorado.getPreco();
    }
}

