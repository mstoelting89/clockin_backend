package com.clockin.clockin_backend.registration;

import org.springframework.stereotype.Service;

@Service
public class RegistrationValidateEmail {

    public boolean validate(String email) {

        String regex = "^[a-zA-Z0-9._-]*@[a-zA-Z0-9_-]*.[a-z]*";
        return email.matches(regex);
    }
}
