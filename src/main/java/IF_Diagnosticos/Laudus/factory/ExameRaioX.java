

package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameRaioX extends Exame {
    private String regiao; // "Abdominal" etc.
    private String laudoDescricao;
    private String imagem;

    public ExameRaioX(Paciente paciente, Medico solicitante, Medico responsavel,
                      Prioridade prioridade, String regiao, String imagem) {
        super(prioridade, paciente, solicitante);
        this.regiao = regiao;
        this.imagem = imagem;
        this.laudoDescricao = "";
        setValorBase(150);
    }

    public String getTipo(){ return "Raio-X"; }
    public String getRegiao(){ return regiao; }
    public String getImagem(){ return imagem; }
    public String getLaudoDescricao(){ return laudoDescricao; }
    public void setLaudoDescricao(String desc){ this.laudoDescricao = desc; }

}
