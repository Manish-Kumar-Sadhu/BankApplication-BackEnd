package com.resilience.spring.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageController {

	@Autowired
	public JavaMailSender mailSender;

//	public void sendMail(String to, String subject, String text) {
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(text);
//		jms.send(message);
//	}
	
//	CustomerEmailMessage ces =  new CustomerEmailMessage();
//	String to=ces.getTo(); 
//	String subject=ces.getSubject(); 
//	String message=ces.getMessage(); 

	public void sendMail() throws MessagingException
	{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		//String htmlMsg = "<h3>Hello World!</h3>";
		//CustomerEmailMessage ces =  new CustomerEmailMessage();
		String to=CustomerEmailMessage.to; 
		String subject=CustomerEmailMessage.subject; 
		String message=CustomerEmailMessage.message;
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(message, true);

		mailSender.send(mimeMessage);
	}
}
