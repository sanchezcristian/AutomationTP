package utils;



import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import utils.XMLReader;


public class MailSender {
	private XMLReader reader = new XMLReader();
	
	public void sendMail() {
		Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.outlook.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.socketFactory.port", "587");
        props.setProperty("mail.user", "cristiantest1234@outlook.com");
        //props.setProperty("mail.user", "cristiantest1234@gmail.com");
        props.setProperty("mail.password", "SapoPepe");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        ZipUtils zipFile = new ZipUtils();
        try {
        	zipFile.createZip();
			message.setFrom(new InternetAddress("cristiantest1234@outlook.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(reader.readNode("recipient-email"))); //CC or BCC
			message.setSubject("Reporte del test 4");
			//message.setText("Envio del reporte del test");
			BodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Envio del reporte del test 2");
			String filename = "C:\\Users\\csanchez\\eclipse-workspace\\AutomationTP\\Folder.zip";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport t = session.getTransport("smtp");
			t.connect("cristiantest1234@outlook.com","SapoPepe");
			t.sendMessage(message,message.getAllRecipients());
			t.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
}
