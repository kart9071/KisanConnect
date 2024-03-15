package com.example.demo.model;

public class ResetPassword {
    private String email;
    private String password;
    private String otp;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
    public ResetPassword(String email, String password, String otp) {
        this.email = email;
        this.password = password;
        this.otp = otp;
    }
    
    public ResetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
    @Override
    public String toString() {
        return "ResetPassword [email=" + email + ", password=" + password + ", otp=" + otp + "]";
    }
    
}
