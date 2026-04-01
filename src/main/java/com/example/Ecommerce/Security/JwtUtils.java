package com.example.Ecommerce.Security;



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


