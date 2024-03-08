package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RegisterLogin;

@Repository
public interface RegisterLoginRepository extends CrudRepository<RegisterLogin, Integer>{

	RegisterLogin findByUsernameAndPassword(String username, String email);
	RegisterLogin findByEmail(String email);

}
