package com.tb.gmail;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailMailer {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
   
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gopalchaurasiya@gmail.com", "smith@898");
			}
		};

		Session session = Session.getDefaultInstance(props, authenticator);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("loggerdemon@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("smith86327@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kksharmahcl16@gmail.com"));
			message.setSubject("Testing Subject for weekend batch");

			byte[] HTML = Files.readAllBytes(Paths.get("D:\\Remark.txt"));

			String ssss = new String(HTML);

			message.setText("Boss This is for Weekend Batch" + ssss);

			Transport.send(message);

			System.out.println("Done for Java Weekend Batch");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/*
	 * public static void main(String... strings) { Properties properties =
	 * System.getProperties();
	 *
	 * Set<String> set =properties.stringPropertyNames();
	 *
	 * for (Iterator iterator = set.iterator(); iterator.hasNext();) { String string
	 * = (String) iterator.next();
	 *
	 * System.out.println(string+" : "+System.getProperty(string));
	 *
	 * }
	 *
	 * }
	 */
}
