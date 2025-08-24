package IF_Diagnosticos.Laudus.desconto;

import IF_Diagnosticos.Laudus.factory.Exame;

public class ExameDescontoOutubroRosa extends ExameDescontoDecorator {
    public ExameDescontoOutubroRosa(Exame exame) {
        super(exame);
    }
    public double getValorBase() {
        return exame.getValorBase() * 0.95; // 5% de desconto
    }
}
