package IF_Diagnosticos.Laudus.Model.Facate;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.mail.Message.RecipientType;

import IF_Diagnosticos.Laudus.Model.Entities.Paciente;

public class FachadaNotificacaoComunicacao {

    private static final String ACCOUNT_SID = "SEU_SID";
    private static final String AUTH_TOKEN = "SEU_AUTH_TOKEN";

    private final String BOT_TOKEN = "8304980994:AAGwHJ-hfIe6Ftczyqogel6SpCBqxKJA7L0";
    private final String CHAT_ID = "6953556522"; // ID do destinatário

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void enviarEmail(Paciente paciente, String mensagem) {
        final String remetente = "nillocoelho@gmail.com";
        final String senha = "mtvm nvgc ryol tfmx"; // NÃO use sua senha normal!

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(RecipientType.TO, InternetAddress.parse("jessye.pereira@academico.ifpb.edu.br"));
            message.setSubject("Notificação");
            message.setText("Olá " + paciente.getNome() + ",\n\n" + mensagem);

            Transport.send(message);
            System.out.println("Email enviado para " + paciente.getNome());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void enviarTelegram(Paciente paciente, String mensagem) {
        try {
            String text = "Olá " + paciente.getNome() + ", " + mensagem;
            String encodedMessage = URLEncoder.encode(text, "UTF-8");

            String urlString = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    BOT_TOKEN, CHAT_ID, encodedMessage);

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                System.out.println("Mensagem Telegram enviada para " + paciente.getNome());
            } else {
                System.out.println("Erro ao enviar Telegram: HTTP " + conn.getResponseCode());
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
