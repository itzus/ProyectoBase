package com.asw.test.app.base.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.stereotype.Component;

import jakarta.activation.DataHandler;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;

@Component
public class SendMail {

	 public static void main(String[] args) throws MessagingException {
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");

	        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("sayutibe@gmail.com", "akpz314qwerty_gmail");
	            }
	        });

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("sayutibe@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sayutibe@gmail.com"));
	        message.setSubject("Asunto del correo");

	        MimeBodyPart mimeBodyPart = new MimeBodyPart();
	        mimeBodyPart.setContent("Cuerpo del correo", "text/html");

	        byte[] bytes = obtenerContenidoDelArchivo();
	        ByteArrayDataSource bds = new ByteArrayDataSource(bytes, "application/octet-stream");

	        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
	        attachmentBodyPart.setDataHandler(new DataHandler(bds));
	        attachmentBodyPart.setFileName("nombre_del_archivo");

	        MimeMultipart mimeMultipart = new MimeMultipart();
	        mimeMultipart.addBodyPart(mimeBodyPart);
	        mimeMultipart.addBodyPart(attachmentBodyPart);

	        message.setContent(mimeMultipart);
	        Transport.send(message);
	    }

	    private static byte[] obtenerContenidoDelArchivo() {
	    	 Path archivoPath = Paths.get("C:\\WORK\\test.pdf");
	         try {
	             return  Files.readAllBytes(archivoPath);
	         } catch (IOException e) {
	        	 return null;
	         }
	    }
	
}
