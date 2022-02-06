package com.clockin.clockin_backend.user;

import com.clockin.clockin_backend.registration.token.Token;
import com.clockin.clockin_backend.registration.token.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public User loadUserByMail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String signUpUser(User user) {

        // check if user exists
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("User is bereits vorhanden");
        }

        // encode password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        // save user
        userRepository.save(user);

        // create token
        String tokenId = UUID.randomUUID().toString();

        Token token = new Token(
                tokenId,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                user
        );

        tokenService.saveToken(token);

        return tokenId;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

    public int unlockUser(String email) {
        return userRepository.unlockUser(email);
    }
}
