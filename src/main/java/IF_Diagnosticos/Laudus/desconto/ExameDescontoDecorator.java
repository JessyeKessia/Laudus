package IF_Diagnosticos.Laudus.desconto;

import IF_Diagnosticos.Laudus.factory.Exame;

public abstract class ExameDescontoDecorator extends Exame {
    protected Exame exame;

    public ExameDescontoDecorator(Exame exame) {
        super(exame.getPrioridade(), exame.getPaciente(), exame.getMedico());
        this.exame = exame;
    }

    public String getTipo() {
        return exame.getTipo();
    }

    public double getValorBase() {
        return exame.getValorBase();
    }
}
