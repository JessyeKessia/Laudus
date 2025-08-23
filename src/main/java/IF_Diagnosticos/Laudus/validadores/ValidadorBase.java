package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaborial;

public abstract class ValidadorBase implements ValidadorSanguineo {
    protected ValidadorSanguineo proximo;

    public void setProximo(ValidadorSanguineo proximo) {
        this.proximo = proximo;
    }

    public String handle(ExameLaborial exame) {
        if (proximo != null) {
            return proximo.handle(exame);
        }
        // último da cadeia: pode retornar vazio ou lançar exceção
        return "Sem validador aplicável para o tipo: " + exame.getEspecialidade();
    }
}