package com.Shaheer.smms.Service;

import com.Shaheer.smms.Model.AuthUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JWTService {
    @Value("${smms.token}")
    private String SECRET_KEY;

    public String generateToken(UserDetails userdetails){
        HashMap<String, Object> claims = new HashMap<>();

        if (userdetails instanceof AuthUser) {
            claims.put("role", ((AuthUser) userdetails).getRole().name());
        }

        return Jwts.builder()
                .claims(claims)
                .subject(userdetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSignInKey())
                .compact();
    }


    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return(username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extracAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extracAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
