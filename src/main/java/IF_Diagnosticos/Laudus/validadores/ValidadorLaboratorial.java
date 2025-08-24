
package IF_Diagnosticos.Laudus.validadores;

import IF_Diagnosticos.Laudus.factory.ExameLaboratorial;

public interface ValidadorLaboratorial {
    void setProximo(ValidadorLaboratorial proximo);
    String handle(ExameLaboratorial exame);
}
