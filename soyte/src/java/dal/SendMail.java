package dal;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author quang
 */
public class SendMail {

   private final String MAIL = "soytengheanexample@gmail.com";
   private final String PASSWORD = "quangthai123456";

   public void sentEmail(String toEmail, String subject, String text) {

      // Config
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");

      // Authenticator
      Session session = Session.getInstance(props, new Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(MAIL, PASSWORD);
         }
      });

      // Mail info
      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(MAIL));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
         message.setSubject(subject);
         message.setText(text);

         Transport.send(message);
         System.out.println("Message sent successfully...");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }

   public static void main(String[] args) {
   }
}
