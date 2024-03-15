package com.example.demo.controller;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisterLogin;
import com.example.demo.model.ResetPassword;
import com.example.demo.service.RegisterLoginService;
import com.example.demo.service.ResetPasswordService;

@RestController
public class ResetPasswordController {
	@Autowired
	private ResetPasswordService resetpasswordservice;

	@Autowired
	private RegisterLoginService registerloginservice;

	@PostMapping("/send-otp")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> sendOtpByEmail(@RequestBody RegisterLogin user) {
		String email = user.getEmail();
		boolean check = emailPresent(email);
		if (check) {
			Integer otp = generateOtp();
			String subject = "Thank you for the request to change password. Here is your OTP. Don't send this OTP to anyone.";
			String body = "YOUR ONE TIME PASSWORD IS " + otp;
			try {
				resetpasswordservice.sendEmail(email, subject, body);
				System.out.println("Email sent successfully!");
				resetpasswordservice.storeOtp(email, otp);
				return ResponseEntity.ok().body("{\"status\": \"success\"}");
			} catch (MessagingException e) {
				System.out.println("Failed to send email: " + e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
			}
		} else {
			System.out.println("Email is not present...");
			return ResponseEntity.ok().body("{\"status\": \"failure\"}");
		}
	}


	@PostMapping("/verify-otp")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> verifyOtp(@RequestBody  ResetPassword user) {

		Integer otp = Integer.parseInt(user.getOtp());
		Integer storedOtp = resetpasswordservice.getOtp(user.getEmail());
	
		if (otp.equals(storedOtp)) {
			System.out.println("OTP verified successfully");
			resetpasswordservice.removeOtp(user.getEmail());
			return ResponseEntity.ok().body("{\"status\": \"success\"}");
		} else {
			System.out.println("Invalid OTP");
			return ResponseEntity.ok().body("{\"status\": \"failure\"}");
		}
	}


	@PostMapping("/submit-NewPassword")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> resetPassword(@RequestBody ResetPassword user){
		RegisterLogin userpresnt = registerloginservice.fetchUserByEmail(user.getEmail());
		if (userpresnt != null && user.getEmail().equals(user.getEmail())) {
			userpresnt.setPassword(user.getPassword());
			registerloginservice.saveUser(userpresnt);
			System.out.println("reset password successfully");
			return ResponseEntity.ok().body("{\"status\": \"success\"}");
		}
		else{
			System.out.println("cann't reset password");
			return ResponseEntity.ok().body("{\"status\": \"failure\"}");
		}
		
	}



	public int generateOtp() {
		Random random = new Random();
		int otp = random.nextInt(9000) + 1000;
		System.out.println(otp);
		return otp;
	}

	public boolean emailPresent(String email) {
		boolean check;
		RegisterLogin user = registerloginservice.fetchUserByEmail(email);
		if (user != null && user.getEmail().equals(email)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
}
