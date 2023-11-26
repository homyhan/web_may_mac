package helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static boolean sendMail(String to, String subject, String text) {
		//https://www.youtube.com/watch?v=0ignaDR1UOs
		final String email = "trucmainguyen02@gmail.com";//email gui thu
		final String password = "pbpfganrroiylmuq";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(email, password);
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);  
			// message.setHeader("Content-Type", "text/plain; charset=UTF-8");
	         message.setFrom(new InternetAddress(email));  
	         message.addRecipient(Message.RecipientType.TO,  
	                                  new InternetAddress(to));  
	        message.setSubject(subject);  
	        message.setContent(text,"text/html" );  
	       Transport.send(message);  
			System.out.println("Sent message successfully");
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String textMail = "<a href=\"localhost:8080/tai-khoan/reset-password?username="+"mainguyen"+"&token="+Contants.PASSWORD_DEFAULT+"\">link</a>";
		System.out.println(textMail);
		System.out.println(sendMail("trucmainguyen02@gmail.com", "MBA", textMail));
	}
}