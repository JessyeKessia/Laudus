package IF_Diagnosticos.Laudus.factory;

import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.entidades.Paciente;

public interface Exame {
    void realizar();
    String getId();
    String getTipo();
    String getData();
    Paciente getPaciente();
    Medico getMedico();
}