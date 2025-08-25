package IF_Diagnosticos.Laudus.facade;

import IF_Diagnosticos.Laudus.entidades.Paciente;
import IF_Diagnosticos.Laudus.notificacao.EmailSender;
import jakarta.mail.MessagingException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FachadaNotificacaoComunicacao {

    private final EmailSender emailSender;
    
    private final String TELEGRAM_BOT_TOKEN = "8304980994:AAGwHJ-hfIe6Ftczyqogel6SpCBqxKJA7L0";
    private final String TELEGRAM_CHAT_ID = "6953556522";

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
        try {
            String texto = "Olá " + paciente.getNome() + ",\n" + mensagem;
            String encodedMessage = URLEncoder.encode(texto, StandardCharsets.UTF_8.toString());

            String urlString = String.format(
                "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                TELEGRAM_BOT_TOKEN, TELEGRAM_CHAT_ID, encodedMessage
            );

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("[TELEGRAM] Mensagem enviada com sucesso para: " + paciente.getNome());
            } else {
                InputStream errorStream = conn.getErrorStream();
                String responseBody = "N/A";
                if (errorStream != null) {
                    try (Scanner scanner = new Scanner(errorStream)) {
                        responseBody = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                    }
                }
                System.err.println("❌ Erro ao enviar Telegram para " + paciente.getNome() + ". Código HTTP: " + responseCode + ". Resposta: " + responseBody);
            }
            conn.disconnect();
        } catch (Exception e) {
            System.err.println("❌ Exceção ao tentar enviar Telegram para " + paciente.getNome());
            e.printStackTrace();
        }
    }
}
