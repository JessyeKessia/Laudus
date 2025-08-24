package IF_Diagnosticos.Laudus.notificacao;

import IF_Diagnosticos.Laudus.entidades.Paciente;
import jakarta.mail.MessagingException;

import java.io.File;
import java.io.IOException;
// ... outros imports de Telegram
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class FachadaNotificacaoComunicacao {

    private final EmailSender emailSender;
    // ... Credenciais do Telegram
    
    public FachadaNotificacaoComunicacao(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void enviarEmail(Paciente paciente, String mensagem, File anexo) {
        try {
            String assunto = "Seu Laudo Médico foi Emitido - Clínica Laudus";
            String corpoEmail = "Olá " + paciente.getNome() + ",\n\n" + mensagem;
            
            emailSender.enviar(paciente.getEmail(), assunto, corpoEmail, anexo);
            
            String logAnexo = (anexo != null) ? " com o laudo em anexo." : ".";
            System.out.println("[EMAIL] Mensagem enviada para " + paciente.getEmail() + logAnexo);
            
        } catch (MessagingException | IOException e) {
            System.err.println("Falha ao enviar e-mail com anexo para " + paciente.getEmail() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void enviarTelegram(Paciente paciente, String mensagem) {
        // ... sua implementação de enviarTelegram continua a mesma
    }
}