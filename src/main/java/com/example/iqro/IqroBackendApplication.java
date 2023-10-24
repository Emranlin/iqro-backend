package com.example.iqro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
public class IqroBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IqroBackendApplication.class, args);
	}

	@GetMapping("/")
	public String greeting() {
		return "<h1> Welcome to IQRO <h1>";
	}
}
