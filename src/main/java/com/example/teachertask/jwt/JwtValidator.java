package com.example.teachertask.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtValidator {

    private final String secretKey = "345hu34bnhsiddfg3453453dfgv34564645ghf4576fmni32imvid8";

    public Claims validateToken(String token) {
        try {
            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
            SecretKey key = Keys.hmacShaKeyFor(keyBytes);


            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {

            throw new RuntimeException("Invalid JWT token: " + e.getMessage(), e);
        }
    }
}
