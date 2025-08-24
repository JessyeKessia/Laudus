

package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.factory.Exame;
import java.io.File;
import IF_Diagnosticos.Laudus.notificacao.*;
import IF_Diagnosticos.Laudus.pagamento.*;
import IF_Diagnosticos.Laudus.prioridade.FilaPrioridade;

public class SistemaDiagnosticoFacade {
    private final ValidadorExame validador;
    private final FilaPrioridade fila;
    private final EmissorLaudo emissor;
    private final AssuntoNotificacao assunto;
    private final Pagamento pagamento;
    private final EmailSender emailSender;

    public SistemaDiagnosticoFacade(ValidadorExame validador, FilaPrioridade fila, EmissorLaudo emissor, AssuntoNotificacao assunto, Pagamento pagamento, EmailSender emailSender){
        this.validador = validador;
        this.fila = fila;
        this.emissor = emissor;
        this.assunto = assunto;
        this.pagamento = pagamento;
        this.emailSender = emailSender;
    }

    public void processar(Exame exame, boolean aplicarOutubroRosa){
        // 1) Pagamento
        boolean ok = pagamento.processarPagamento(exame, aplicarOutubroRosa);
        if (!ok) {
            System.out.println("Falha no pagamento. Exame não seguirá para processamento.");
            return;
        }

        // 2) Fila por prioridade
        fila.adicionarExame(exame);
        Exame exam = fila.processarProximo();

        // 3) Validação
        String conteudo = validador.validar(exam);

        // 4) Emissão (TXT, HTML e PDF via Bridge/Adapter)
        emissor.gerarArquivosLaudo(exam, conteudo);

        // 5) Notificação (Observer)
        assunto.notificar(exam.getPaciente(), "Seu laudo (" + exam.getTipo() + " - " + exam.getPrioridade() + ") foi emitido. Arquivo PDF: " + caminhoPdf);

        // 6) Envio do PDF por e-mail
        String destinatario = exam.getPaciente().getEmail();
        String assuntoEmail = "Seu laudo médico foi emitido";
        String mensagemEmail = "Olá, segue em anexo o seu laudo médico em PDF.";
        File pdfFile = new File(caminhoPdf);
        emailSender.enviarComAnexo(destinatario, assuntoEmail, mensagemEmail, pdfFile);
    }
}
