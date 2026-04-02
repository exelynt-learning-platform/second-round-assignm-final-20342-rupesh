package com.example.Ecommerce.Service;

import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Repository.UserRepository;
import com.example.Ecommerce.Dto.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public String registerUser(SignupRequest signupRequest) {

		if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
			return "Email already exists!";
		}

		User user = new User();
		user.setEmail(signupRequest.getEmail());

		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		user.setRole(signupRequest.getRole());

		userRepository.save(user);
		return "User registered successfully!";
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
