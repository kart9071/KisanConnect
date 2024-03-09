package com.example.demo.controller;

import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisterLogin;
import com.example.demo.service.EmailService;

@RestController
public class ResetPasswordController {
	@Autowired
	private EmailService emailService;
//	@PostMapping("/resetPassword")
//	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/resetpassword")
	public void  resetPassword() throws Exception{
//		String email=user.getEmail();
//		String password=user.getPassword();
		Random random = new Random();
		int randomNumber = random.nextInt(9000) + 1000;
        String toEmail = "karthikshetty200313@gmail.com"; // Replace with the recipient's email address
        String subject = "Your Random Number";
        String body = "Your random number is: " + randomNumber;
        try {
            emailService.sendEmail(toEmail, subject, body);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
	}
}
