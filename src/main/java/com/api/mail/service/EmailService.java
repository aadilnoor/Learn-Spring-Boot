package com.api.mail.service;

import java.io.File; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

   
    public void sendSimpleEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("poolb4471@gmail.com");

        mailSender.send(message);
//        System.out.println("Mail Send Successfully ...");
        log.info("Mail Send Successfully ...");
    }

   
    public void sendEmailWithAttachment(String toEmail, String subject, String body, String attachmentPath) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body);
        helper.setFrom("poolb4471@gmail.com");

       
        FileSystemResource file = new FileSystemResource(new File(attachmentPath));
        if (file.exists()) {
            helper.addAttachment(file.getFilename(), file);
        } else {
//            System.out.println("Attachment file not found!");
            log.info("Attachment file not found!");
            throw new MessagingException("Attachment file not found");
        }

        mailSender.send(mimeMessage);
//        System.out.println("Mail Send with Attachment successfully...");
        log.info("Mail Send with Attachment successfully...");
    }
}
