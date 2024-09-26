package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "8081");
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
