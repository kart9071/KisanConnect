package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RegisterLogin;
import com.example.demo.repository.RegisterLoginRepository;

@Service
public class RegisterLoginService {
	@Autowired
	private RegisterLoginRepository registerloginrepo;
		
	public RegisterLogin saveUser(RegisterLogin user)
	{
		return registerloginrepo.save(user);
	}
	
	public RegisterLogin fetchByUsernameAndPassword(String username, String email)
	{
		return registerloginrepo.findByUsernameAndPassword(username, email);
	}
	
	public RegisterLogin fetchUserByEmail(String email)
	{
		return registerloginrepo.findByEmail(email);
	}
	
}
