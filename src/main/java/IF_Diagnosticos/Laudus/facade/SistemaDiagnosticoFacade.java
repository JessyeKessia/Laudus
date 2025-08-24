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

    public SistemaDiagnosticoFacade(ValidadorExame validador, FilaPrioridade fila, EmissorLaudo emissor, AssuntoNotificacao assunto, Pagamento pagamento) {
        this.validador = validador;
        this.fila = fila;
        this.emissor = emissor;
        this.assunto = assunto;
        this.pagamento = pagamento;
    }

    public void processar(Exame exame, boolean aplicarOutubroRosa) {
        // --- ETAPA 1: PAGAMENTO ---
        boolean pagamentoAprovado = pagamento.processarPagamento(exame, aplicarOutubroRosa);
        if (!pagamentoAprovado) {
            System.out.println("Processamento do exame para " + exame.getPaciente().getNome() + " interrompido devido à falha no pagamento.");
            System.out.println("----------------------------------------------------");
            return; 
        }
        System.out.println("Pagamento aprovado. Prosseguindo com o processamento do exame...");

        // --- ETAPA 2: FILA DE PRIORIDADE ---
        fila.adicionarExame(exame);
        Exame exam = fila.processarProximo(); 

        // --- ETAPA 3: VALIDAÇÃO (COM VERIFICAÇÃO) ---
        // O método 'validar' agora retorna um objeto 'ResultadoValidacao'.
        ResultadoValidacao resultado = validador.validar(exam);

        // Verificamos o status do resultado. Se não for sucesso, interrompemos o fluxo.
        if (!resultado.isSucesso()) {
            System.out.println("Processamento interrompido. Motivo: " + resultado.getConteudo());
            // Opcional: você poderia notificar o paciente sobre o cancelamento aqui se quisesse.
            // assunto.notificar(exam.getPaciente(), resultado.getConteudo(), null);
            System.out.println("----------------------------------------------------");
            return; // INTERROMPE O PROCESSO AQUI
        }

        // Se a validação foi um sucesso, pegamos o conteúdo para prosseguir.
        String conteudo = resultado.getConteudo();

        // --- ETAPA 4: EMISSÃO DE LAUDO ---
        File laudoPdf = emissor.gerarArquivosLaudo(exam, conteudo);

        // --- ETAPA 5: NOTIFICAÇÃO ---
        if (laudoPdf != null && laudoPdf.exists()) {
            String mensagem = "Seu laudo (" + exam.getTipo() + ") foi emitido com sucesso e segue em anexo para seu email.";
            assunto.notificar(exam.getPaciente(), mensagem, laudoPdf);
        } else {
            String mensagemDeErro = "Seu laudo (" + exam.getTipo() + ") foi processado, mas houve um erro ao gerar o arquivo PDF. Por favor, entre em contato com a clínica.";
            assunto.notificar(exam.getPaciente(), mensagemDeErro, null);
        }
        System.out.println("----------------------------------------------------");
    }
}
