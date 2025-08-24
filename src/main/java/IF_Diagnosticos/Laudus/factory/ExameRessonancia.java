

package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;

public class ExameRessonancia extends Exame {

    private String regiao;
    private String laudoDescricao;
    private String tipoContraste;
    private double dosagemContraste;
    private boolean possuiMarcapasso;
    private boolean possuiImplantesMetalicos;
    private boolean utilizouContraste;

    public ExameRessonancia(Paciente paciente, Medico solicitante, Medico responsavel,
                            Prioridade prioridade, String regiao,
                            boolean utilizouContraste, String tipoContraste, double dosagemContraste,
                            boolean possuiMarcapasso, boolean possuiImplantesMetalicos) {
        super(prioridade, paciente, solicitante);
        this.regiao = regiao;
        this.laudoDescricao = "";
        this.utilizouContraste = utilizouContraste;
        this.tipoContraste = tipoContraste;
        this.dosagemContraste = dosagemContraste;
        this.possuiMarcapasso = possuiMarcapasso;
        this.possuiImplantesMetalicos = possuiImplantesMetalicos;
        setValorBase(400);
    }

    public String getTipo(){ return "Ressonância"; }
    public String getRegiao(){ return regiao; }
    public String getLaudoDescricao(){ return laudoDescricao; }
    public void setLaudoDescricao(String desc){ this.laudoDescricao = desc; }

    // Para compatibilidade com ValidadorExame
    public boolean getUtilizouContraste() { return utilizouContraste; }
    public void setUtilizouContraste(boolean utilizouContraste) { this.utilizouContraste = utilizouContraste; }

    public String getTipoContraste() { return tipoContraste; }
    public void setTipoContraste(String tipoContraste) { this.tipoContraste = tipoContraste; }

    public double getDosagemContraste() { return dosagemContraste; }
    public void setDosagemContraste(double dosagemContraste) { this.dosagemContraste = dosagemContraste; }

    public boolean isPossuiMarcapasso() { return possuiMarcapasso; }
    public void setPossuiMarcapasso(boolean possuiMarcapasso) { this.possuiMarcapasso = possuiMarcapasso; }

    public boolean isPossuiImplantesMetalicos() { return possuiImplantesMetalicos; }
    public void setPossuiImplantesMetalicos(boolean possuiImplantesMetalicos) { this.possuiImplantesMetalicos = possuiImplantesMetalicos; }
}
