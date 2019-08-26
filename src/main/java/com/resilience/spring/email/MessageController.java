//package com.resilience.spring.email;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class MessageController{
//
//	@Autowired
//	private JavaMailSender jms;
//	
//	public String sendMail(String to, String subject, String text) 
//	{
////		System.out.println(to);
////		System.out.println(subject);
////		System.out.println(text);
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(to);
//		//System.out.println(to);
//		message.setSubject(subject);
//		message.setText(text);
//		jms.send(message);
//		return "successfully sent";
//	}
//}
