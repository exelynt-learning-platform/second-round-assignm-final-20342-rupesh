package com.Ecommerce.MultiGenesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = { "com.example", "com.Ecommerce", "com.E_commerce" })
@EnableJpaRepositories(basePackages = { "com.example", "com.Ecommerce", "com.E_commerce" })
@EntityScan(basePackages = { "com.example", "com.Ecommerce", "com.E_commerce" })
public class MultiGenesysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiGenesysApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
