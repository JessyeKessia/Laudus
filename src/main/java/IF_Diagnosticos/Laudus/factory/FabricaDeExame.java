package IF_Diagnosticos.Laudus.factory;

// Criador: a fábrica abstrata que define o método para criar exames.
public abstract class FabricaDeExame {
    // O Factory Method que as subclasses irão implementar
    public abstract Exame criarExame(String... dados);
}