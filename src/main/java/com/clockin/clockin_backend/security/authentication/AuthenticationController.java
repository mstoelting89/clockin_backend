package com.clockin.clockin_backend.security.authentication;

import com.clockin.clockin_backend.security.jwt.authentication.JwtAuthenticationService;
import com.clockin.clockin_backend.security.jwt.token.JwtTokenDto;
import com.clockin.clockin_backend.user.User;
import com.clockin.clockin_backend.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "/api/v1/login")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private JwtAuthenticationService jwtAuthenticationService;
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody AuthenticationDto authenticationDto) {

        JwtTokenDto token = authenticationService.generateJwtToken(authenticationDto.getEmail(), authenticationDto.getPassword());
        User user = userService.loadUserByMail(authenticationDto.getEmail());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(
                token.getToken(),
                user.getAuthorities()
        );

        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/forgotpassword")
    public ResponseEntity<?> forgotPassword (@RequestParam("email") String email) {
        return new ResponseEntity<>(userService.handleForgotPassword(email), HttpStatus.OK);
    }

    @PostMapping(path = "/resetpassword")
    public ResponseEntity<?> resetPassword (@RequestBody ResetPasswordDto resetPasswordDto) {
        return new ResponseEntity<>(userService.resetPassword(resetPasswordDto.getToken(), resetPasswordDto.getPassword()), HttpStatus.OK);
    }

    @GetMapping(path = "/confirm")
    public ResponseEntity<?> confirm (@RequestParam("token") String token) {
        return new ResponseEntity<>(userService.confirmForgotPasswordToken(token), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handlerEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
