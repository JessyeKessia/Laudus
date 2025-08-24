package IF_Diagnosticos.Laudus.desconto;

import IF_Diagnosticos.Laudus.factory.Exame;

public class ExameDescontoConvenio extends ExameDescontoDecorator {
    private double percentual;

    public ExameDescontoConvenio(Exame exame, double percentual) {
        super(exame);
        this.percentual = percentual;
    }

    @Override
    public double getValorBase() {
        return exame.getValorBase() * (1.0 - percentual);
    }
}