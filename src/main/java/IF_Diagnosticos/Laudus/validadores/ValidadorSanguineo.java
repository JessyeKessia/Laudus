package IF_Diagnosticos.Laudus.validadores;

public interface ValidadorSanguineo {
    void setProximo(ValidadorSanguineo proximo);
    String handle(Laudo exame);
}
