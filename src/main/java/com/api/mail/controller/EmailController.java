package com.api.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mail.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send-email")
	public String sendEmail(
			@RequestParam String toEmail, 
			@RequestParam String subject, 
			@RequestParam String body)
	{
		emailService.sendSimpleEmail(toEmail, subject, body);
		return "Simple email sended successfully!";
	}

	
	@PostMapping("/send-email-with-attachment")
	public String sendEmailWithAttachment(
			@RequestParam String toEmail, 
			@RequestParam String subject,
			@RequestParam String body, 
			@RequestParam String attachmentPath) {
		try {
			emailService.sendEmailWithAttachment(toEmail, subject, body, attachmentPath);
			return "Mail with attachment success!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occurred while sending attachment: " + e.getMessage();
		}
	}
}
