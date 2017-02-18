import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	
	
	public void sendmailforstudent(String mail)
	{
	
	String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "sachinbhondave9@gmail.com";
        String password = "sachin@321";
 
        // message info
        String mailTo = mail;
        String subject = "New email with attachments";
        String message = "I have some attachments for you.";
	
        String attachFiles = new String();
        attachFiles = "D:\\Bill.pdf";
        System.out.println("file"+attachFiles.toString());
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                subject, message,attachFiles);
	            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
	}
	
	public static void sendEmailWithAttachments(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message,String attachFiles)
            throws AddressException, MessagingException {
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // creates a new session with an authenticator
      Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
       
        session.setDebug(true);
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
       if (attachFiles != null ) {
          
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(attachFiles);
                } catch (IOException ex) {
                	System.out.println("nothing attch");
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            
        }
 
        // sets the multi-part as e-mail's content
         msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);

    }

}
