package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class UserServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8082");
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
