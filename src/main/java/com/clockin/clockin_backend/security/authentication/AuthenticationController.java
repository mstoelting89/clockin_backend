package com.clockin.clockin_backend.security.authentication;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @PostMapping("/api/v1/login")
    public ResponseEntity createCustomer(@RequestBody AuthenticationRequest authenticationRequest) {
        return new ResponseEntity(authenticationService.generateJwtToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
