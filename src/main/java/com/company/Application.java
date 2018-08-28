package com.company;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.company.model.User;
import com.company.repo.UserRepository;

@SpringBootApplication
public class Application {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		for (int i = 0; i < 42; i++) {
			userRepo.save(new User(null, UUID.randomUUID().toString(), 
					UUID.randomUUID().toString() , passwordEncoder.encode("123")));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
