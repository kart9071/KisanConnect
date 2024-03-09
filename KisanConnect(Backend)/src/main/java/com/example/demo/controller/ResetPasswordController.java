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
	@PostMapping("/resetpassword")
	@CrossOrigin(origins="http://localhost:4200")
	public void  resetPassword(@RequestBody RegisterLogin user) throws Exception{
		String email=user.getEmail();
		String password=user.getPassword();
		Random random = new Random();
		int randomNumber = random.nextInt(9000) + 1000;
//        String toEmail = "karthikshetty200313@gmail.com"; // Replace with the recipient's email address
		System.out.println("your password is: "+password);
        String subject = "Thanl you for the request to change password Here is your OTP, Don't send this OTP to anyone";
        String body = "YOUR ONE TIME PASSWORD IS " + randomNumber;
        try {
            emailService.sendEmail(email, subject, body);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
	}
//	@PostMapping("/resetpassword/otp")
//	@CrossOrigin(origins="http://localhost:4200")
//	public void otpController(int randomNumner,@RequestBody Object user) {
//		
//	}
}
