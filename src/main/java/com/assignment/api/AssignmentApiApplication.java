package com.assignment.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.api.entity.User;
import com.assignment.api.repository.UserRepository;

@SpringBootApplication
public class AssignmentApiApplication {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers() {
		userRepository.save(new User(444777, "abcdef"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentApiApplication.class, args);
	}

}
