package com.example.Ecommerce.Dto;

import lombok.Data;

@Data
public class SignupRequest {
	private String email;
	private String password;
	private String role;
}
