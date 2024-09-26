package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProductServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8080"); // This line can be remove because Port is already pre define in 8080
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
