package com.learn.app.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.learn.app.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	String from = "sumit46522@gmail.com";

	@Override
	public boolean sendEmail(String subject, String message, String to, String cc) {

		boolean f = false;
		String host = "smtp.gmail.com";
		// get properties
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sumit46522@gmail.com", "Learnmail");
			}

		});

		session.setDebug(true);

		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			mimeMessage.setFrom(from);
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
//			mimeMessage.setHeader("X-Priority", "1");
			mimeMessage.addHeader("X-Priority", "1");

			Transport.send(mimeMessage);
			System.out.println("Send successfully");
			f = true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;

	}

}
