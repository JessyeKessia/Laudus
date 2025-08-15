package IF_Diagnosticos.Laudus.validadores;
import IF_Diagnosticos.Laudus.exames.Exame;

public abstract class ValidadorBase implements Validador {
    protected Validador proximo;

    public void setProximo(Validador proximo) {
        this.proximo = proximo;
    }

    public void handle(Exame exame) throws Exception {
        if (!validar(exame)) {
            throw new Exception("Exame inválido: " + exame.getTipo());
        }
        if (proximo != null) {
            proximo.handle(exame); // passa para o próximo validador
        }
    }

    // cada validador concreto implementa sua regra
    protected abstract boolean validar(Exame exame);
}