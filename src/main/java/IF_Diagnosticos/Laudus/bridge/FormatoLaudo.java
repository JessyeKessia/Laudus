package IF_Diagnosticos.Laudus.bridge;

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;

public interface FormatoLaudo {
    File gerar(Exame exame, String conteudo);
}
