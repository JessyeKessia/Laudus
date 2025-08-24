package IF_Diagnosticos.Laudus.desconto;

import IF_Diagnosticos.Laudus.factory.Exame;

public class ExameDescontoIdoso extends ExameDescontoDecorator {
    public ExameDescontoIdoso(Exame exame) {
        super(exame);
    }

    public double getValorBase() {
        return exame.getValorBase() * 0.85; // 15% de desconto
    }
}
