package Util.UserComunicator;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Mail {
    public static void sendMail(String destination, String object, String content) {
        String host = "127.0.0.1";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply@test-app.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destination));
            message.setSubject(object);
            message.setText(content);
            Transport.send(message);
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}
