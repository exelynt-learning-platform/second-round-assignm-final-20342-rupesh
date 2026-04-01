package com.example.Ecommerce.Security;

<<<<<<< HEAD
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value; // ही नवीन ओळ ऍड केली आहे
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs; 

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
=======


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
  private final String jwtSecret = "TumchaKhupMothaAniSecureSecretKeyItheTaka123456";
  private final int jwtExpirationMs = 86400000; 

  private Key getSigningKey() {
  return Keys.hmacShaKeyFor(jwtSecret.getBytes());
	  }

public String generateToken(String email) {
  return Jwts.builder()
	 .setSubject(email)
	 .setIssuedAt(new Date())
     .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
     .signWith(getSigningKey(), SignatureAlgorithm.HS256)
	 .compact();
	    }

   public String getEmailFromToken(String token) {
	    return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
	            .parseClaimsJws(token).getBody().getSubject();
	    }

      public boolean validateToken(String token) {
	       try {
	    Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
	        return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}


>>>>>>> e246e3a2d95044c5c0108f0aab786541cdacdb24
