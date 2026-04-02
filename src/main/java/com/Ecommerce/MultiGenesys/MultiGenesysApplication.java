package com.Ecommerce.MultiGenesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// १. इथे scanBasePackages टाकणे सर्वात महत्त्वाचे आहे (याने तो एरर कायमचा जाईल)
@SpringBootApplication(scanBasePackages = { "com.Ecommerce.MultiGenesys", "com.example.Ecommerce" })
@EnableJpaRepositories(basePackages = { "com.Ecommerce.MultiGenesys", "com.example.Ecommerce" })
@EntityScan(basePackages = { "com.Ecommerce.MultiGenesys", "com.example.Ecommerce" })
public class MultiGenesysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiGenesysApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}