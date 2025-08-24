
package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public abstract class ValidadorBase implements ValidadorLaboratorial {
    protected ValidadorLaboratorial proximo;

    public void setProximo(ValidadorLaboratorial proximo){ 
        this.proximo = proximo; 
    }

    public String handle(ExameLaboratorial exame){
        if (proximo != null) return proximo.handle(exame);
        return "Sem validador aplicável para o subtipo: " + exame.getTipo();
    }
}
