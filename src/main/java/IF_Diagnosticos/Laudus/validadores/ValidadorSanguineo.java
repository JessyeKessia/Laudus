package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.bridge.LaudoSanguineo;

public interface ValidadorSanguineo {
    void setProximo(ValidadorSanguineo proximo);
    String handle(LaudoSanguineo examesangue);
}
