
package IF_Diagnosticos.Laudus.utils;

public class GeradorNumeroSequencial {
    private static GeradorNumeroSequencial instancia = new GeradorNumeroSequencial();
    private long atual = 1;
    private GeradorNumeroSequencial(){}
    public static GeradorNumeroSequencial getInstancia(){ return instancia; }
    public synchronized long getProximoNumero(){ return atual++; }
}
