package com.clockin.clockin_backend.security.authentication;

import com.clockin.clockin_backend.security.jwt.JwtTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@AllArgsConstructor
@RequestMapping
public class AuthenticationController {

    private AuthenticationService authenticationService;

    /*
    @RequestMapping({"/secret"})
    public String getSecret() {
        //return new ResponseEntity<>(jwtTokenService.getSecret(), HttpStatus.OK);
        return jwtTokenService.getSecret();
    } */

    @PostMapping("/secret")
    public ResponseEntity createCustomer(@RequestBody AuthenticationRequest authenticationRequest) {
        return new ResponseEntity(authenticationService.generateJwtToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
