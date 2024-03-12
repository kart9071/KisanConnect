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
import com.example.demo.service.RegisterLoginService;


@RestController
public class ResetPasswordController {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RegisterLoginService registerloginservice;
	
	@PostMapping("/api/send-otp")
	@CrossOrigin(origins="http://localhost:4200")
	public void  sendOtp(@RequestBody RegisterLogin user) throws Exception{
		int otp=generateOtp();
        sendOtpByEmail(otp,user);
	}
	
	@PostMapping("/api/verify-otp")
	@CrossOrigin(origins="http://localhost:4200")
	public void verifyOtp(@RequestBody int otp) throws Exception{
		
		System.out.println("The otp is: "+otp);
	}
	
	public int generateOtp() {
		Random random = new Random();
		int otp=random.nextInt(9000)+1000;
		return otp;
	}
	
	public void sendOtpByEmail(int otp,RegisterLogin user) {
		String email=user.getEmail();
		String password=user.getPassword();
		boolean check=emailPresent(email,password);
		if(check) {
			String subject = "Thank you for the request to change password Here is your OTP, Don't send this OTP to anyone";
	        String body = "YOUR ONE TIME PASSWORD IS " + otp;
	        try {
	            emailService.sendEmail(email, subject, body);
	            System.out.println("Email sent successfully!");
	        } catch (MessagingException e) {
	            System.out.println("Failed to send email: " + e.getMessage());
	        }
		}
		else {
			System.out.println("Email is not present...");
		}
	}
	
	public boolean emailPresent(String email,String password) {
		boolean check;
		RegisterLogin user=registerloginservice.getUsernameByEmail(email);
		if(user!=null && user.getEmail().equals(email) ) {
			check=true;
		}
		else {
			check=false;
		}
		return check;
	}
}
