package com.clockin.clockin_backend.security.jwt.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@Component
public class JwtAuthenticationService {

    private String secret;

    @Autowired
    public JwtAuthenticationService(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public String getEmailFromToken(String token) {
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenNotExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.after(new Date());
    }

    public Optional<Boolean> validateToken(String token) {
        return isTokenNotExpired(token) ? Optional.of(Boolean.TRUE) : Optional.empty();
    }

    public String extractTokenFromRequest(HttpServletRequest request) {

        final String tokenString = request.getHeader("Authorization");

        if (tokenString != null && tokenString.startsWith("Bearer ")) {
            return tokenString.substring(7);
        } else {
            return null;
        }

    }
}
