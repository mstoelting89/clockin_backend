package com.clockin.clockin_backend.security.authentication;

import com.clockin.clockin_backend.security.jwt.JwtTokenResponse;
import com.clockin.clockin_backend.security.jwt.JwtTokenService;
import com.clockin.clockin_backend.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private UserRepository userRepository;
    private JwtTokenService jwtTokenService;
    private PasswordEncoder passwordEncoder;

    public JwtTokenResponse generateJwtToken(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> new JwtTokenResponse(jwtTokenService.generateToken(email)))
                .orElseThrow(() -> new EntityNotFoundException("Email nicht vorhanden"));
    }

}
