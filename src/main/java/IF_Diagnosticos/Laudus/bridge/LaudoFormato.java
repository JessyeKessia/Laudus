package IF_Diagnosticos.Laudus.bridge;


import IF_Diagnosticos.Laudus.entidades.Medico;
import IF_Diagnosticos.Laudus.factory.Exame;

public interface LaudoFormato {
   String formatarLaudo(LaudoFormato formatador, Exame exame, String conteudo);
}