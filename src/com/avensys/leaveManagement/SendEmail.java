package com.avensys.leaveManagement;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendEmail {

	private String host = "smtp.gmail.com";
	private int port = 587;
	private String username = "avensys.training.cliftons@gmail.com";
	private String password = "Aven,123";
	private String sender = "avensys.training.cliftons@gmail.com";

	public SendEmail() {
		
	}

	public void sendMail(String mgr, String emp, String text) throws Exception {
		
			
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.ssl.trust", host);

		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emp));
			message.setSubject("Leave Approval");

			message.setText(text);

			

			//MimeBodyPart mimeBodyPart = new MimeBodyPart();
			//mimeBodyPart.setContent(message, "text/html");

			//MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			//attachmentBodyPart.attachFile(new File("pom.xml"));

			//Multipart multipart = new MimeMultipart();
			//multipart.addBodyPart(mimeBodyPart);
			//multipart.addBodyPart(attachmentBodyPart);

			//message.setContent(multipart);

			Transport.send(message);

			System.out.println("Email sent");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}