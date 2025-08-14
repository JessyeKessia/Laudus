package IF_Diagnosticos.Laudus.Model.Descontos;

public class PrecoBase implements Desconto {
    @Override
    public double aplicarDesconto(double originalPrice) {
        // Sem desconto na base
        return originalPrice;
    }
}