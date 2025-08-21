package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.entities.Convenio;
import IF_Diagnosticos.Laudus.entities.Medico;
import IF_Diagnosticos.Laudus.entities.Paciente;
import IF_Diagnosticos.Laudus.brigde.Exame;
import IF_Diagnosticos.Laudus.prioridade.FilaPrioridade;
import IF_Diagnosticos.Laudus.prioridade.Prioridade;
import IF_Diagnosticos.Laudus.validadores.ValidadorSanguineo;

public class SistemaDiagnosticoFacade {
    private ValidadorSanguineo validadorAutomatico;
    private ExameSanguineoFactory criadorExame;
    private FilaPrioridade gerenciadorFila;

    public SistemaDiagnosticoFacade(ExameSanguineoFactory criadorExame, FilaPrioridade gerenciadorFila, ValidadorSanguineo validadorAutomatico) {
        this.criadorExame = criadorExame;
        this.gerenciadorFila = gerenciadorFila;
        this.validadorAutomatico = validadorAutomatico;
    }

    public void processaPedidoLaudo(String tipoExame, String nomeExame, double valorExame, String unidadeExame,
                                    Prioridade prioridade, String formatoLaudo, Paciente paciente,
                                    Medico medicoSolicitante, Convenio convenio) {

        // Etapa 1: Criação do Exame (Simple Factory)
        Exame exame = criadorExame.criarExame(tipoExame, nomeExame, valorExame, unidadeExame, prioridade);

        // Etapa 2: Adição à fila (Prioridade)
        gerenciadorFila.adicionarExame(exame);

        // Etapa 3: Processamento do exame e obtenção do conteúdo
        Exame exameProcessado = this.gerenciadorFila.proximoExame();
        String conteudoLaudo;
        if (exameProcessado instanceof ExameSanguineo) {
            conteudoLaudo = validadorAutomatico.processar(exameProcessado);
        } else {
            // Em uma aplicação real, aqui haveria a chamada para a interface do médico.
            conteudoLaudo = "Laudo de exame de imagem (texto simulado).";
        }

        // Etapa 4: Geração do Laudo Final (Bridge)
        FormatoLaudo formato;
        if ("Texto".equalsIgnoreCase(formatoLaudo)) {
            formato = new FormatoTexto();
        } else if ("HTML".equalsIgnoreCase(formatoLaudo)) {
            formato = new FormatoHTML();
        } else {
            formato = new FormatoPDF();
        }

        Laudo laudo = new Laudo(formato);
        laudo.definirDados(paciente, medicoSolicitante, convenio);
        laudo.definirConteudo(conteudoLaudo);

        return laudo.gerarLaudo();
        }
    }
}