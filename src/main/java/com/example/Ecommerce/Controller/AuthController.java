package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Dto.AuthResponse;
import com.example.Ecommerce.Dto.LoginRequest;
import com.example.Ecommerce.Dto.SignupRequest;
import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Security.JwtUtils;
import com.example.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody SignupRequest signupRequest) {
		String message = userService.registerUser(signupRequest);
		return ResponseEntity.ok(message);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		User user = userService.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found!"));

		if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

			String token = jwtUtils.generateToken(user.getEmail());
			return ResponseEntity.ok(new AuthResponse(token));
		} else {
			return ResponseEntity.status(401).body("Invalid credentials!");
		}
	}
}
