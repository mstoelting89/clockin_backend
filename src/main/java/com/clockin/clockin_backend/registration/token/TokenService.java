package com.clockin.clockin_backend.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private TokenRepository tokenRepository;

    // save token
    public void saveToken(Token token) {
        tokenRepository.save(token);
    }

    // get token
    public Optional<Token> getToken(String token) {
        return tokenRepository.findByToken(token);
    }

    // set confirmedAt
    public int setConfirmedAt(String token, LocalDateTime confirmedAt) {
        return tokenRepository.updateConfirmedAt(token, confirmedAt);
    }
}
