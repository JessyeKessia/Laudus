package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.exames.Exame;

public interface Validador {
    void setProximo(Validador proximo);
    void handle(Exame exame) throws Exception;
}
