package IF_Diagnosticos.Laudus.utils;

public class GeradorNumeroSequencial {
    private static GeradorNumeroSequencial instancia;
    private long contador;

    private GeradorNumeroSequencial() {
        this.contador = 0;
    }

    public static synchronized GeradorNumeroSequencial getInstancia() {
        if (instancia == null) {
            instancia = new GeradorNumeroSequencial();
        }
        return instancia;
    }

    public synchronized long getProximoNumero() {
        return ++contador;
    }
}
