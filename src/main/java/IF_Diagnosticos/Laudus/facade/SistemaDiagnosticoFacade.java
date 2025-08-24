package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;
import IF_Diagnosticos.Laudus.notificacao.AssuntoNotificacao;
import IF_Diagnosticos.Laudus.pagamento.*;
import IF_Diagnosticos.Laudus.prioridade.FilaPrioridade;

public class SistemaDiagnosticoFacade {
    private final ValidadorExame validador;
    private final FilaPrioridade fila;
    private final EmissorLaudo emissor;
    private final AssuntoNotificacao assunto;
    private final Pagamento pagamento;

    // O EmailSender foi REMOVIDO daqui. Não é responsabilidade desta fachada.
    public SistemaDiagnosticoFacade(ValidadorExame validador, FilaPrioridade fila, EmissorLaudo emissor, AssuntoNotificacao assunto, Pagamento pagamento) {
        this.validador = validador;
        this.fila = fila;
        this.emissor = emissor;
        this.assunto = assunto;
        this.pagamento = pagamento;
    }

    public void processar(Exame exame, boolean aplicarOutubroRosa) {
        // 1) Pagamento
        boolean ok = pagamento.processarPagamento(exame, aplicarOutubroRosa);
        if (!ok) {
            System.out.println("Falha no pagamento para o exame de " + exame.getPaciente().getNome() + ". Processamento interrompido.");
            return;
        }

        // 2) Fila por prioridade
        fila.adicionarExame(exame);
        Exame exam = fila.processarProximo();

        // 3) Validação
        String conteudo = validador.validar(exam);

        // 4) Emissão, que agora retorna o arquivo PDF gerado
        File laudoPdf = emissor.gerarArquivosLaudo(exam, conteudo);

        // 5) Notificação unificada, enviando o PDF para o sistema de notificação
        if (laudoPdf != null && laudoPdf.exists()) {
            String mensagem = "Seu laudo (" + exam.getTipo() + ") foi emitido com sucesso e segue em anexo.";
            assunto.notificar(exam.getPaciente(), mensagem, laudoPdf);
        } else {
            String mensagemDeErro = "Seu laudo (" + exam.getTipo() + ") foi processado, mas houve um erro ao gerar o arquivo PDF. Por favor, entre em contato com a clínica.";
            assunto.notificar(exam.getPaciente(), mensagemDeErro, null);
        }
    }
}