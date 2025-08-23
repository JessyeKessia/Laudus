package IF_Diagnosticos.Laudus.factory;

public class FabricaLaboratorial extends FabricaDeExames {
    @Override
    public Exame criarExame(String... dados) {
        String tipo = dados[0];
        double valor = Double.parseDouble(dados[1]);
        String unidade = dados[2];
        return new ExameLaboratorial(tipo, valor, unidade);
    }
}