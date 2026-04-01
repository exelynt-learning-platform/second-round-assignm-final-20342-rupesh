package com.example.Ecommerce.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
<<<<<<< HEAD
=======
import org.springframework.security.config.http.SessionCreationPolicy;
>>>>>>> e246e3a2d95044c5c0108f0aab786541cdacdb24
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable)
<<<<<<< HEAD
		.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/api/auth/**").permitAll() 
			    .anyRequest().authenticated()
			);
=======
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/api/auth/**").permitAll().anyRequest().permitAll())
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

>>>>>>> e246e3a2d95044c5c0108f0aab786541cdacdb24
		return http.build();
	}
}