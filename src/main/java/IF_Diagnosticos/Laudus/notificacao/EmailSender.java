package IF_Diagnosticos.Laudus.notificacao;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class EmailSender {
    private final String username;
    private final String password;
    private final String host;
    private final int port;

    public EmailSender(String username, String password, String host, int port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public void enviarComAnexo(String destinatario, String assunto, String mensagem, File anexo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(assunto);

            MimeBodyPart texto = new MimeBodyPart();
            texto.setText(mensagem);

            MimeBodyPart arquivo = new MimeBodyPart();
            arquivo.attachFile(anexo);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(texto);
            multipart.addBodyPart(arquivo);

            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("E-mail enviado para " + destinatario + " com anexo: " + anexo.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
