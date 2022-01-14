package com.clockin.clockin_backend.registration;

import com.clockin.clockin_backend.user.User;
import com.clockin.clockin_backend.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final RegistrationValidateEmail registrationValidateEmail;
    private final UserService userService;

    public String register(RegistrationDto registrationDto){
        // verify email
        boolean validated = registrationValidateEmail.validate(registrationDto.getEmail());
        if (!validated) {
            return "Die Email hat kein korrektes Format";
        }

        // Call sign up methon from UserService
        userService.signUpUser(
                new User(
                        registrationDto.getFirstName(),
                        registrationDto.getLastName(),
                        registrationDto.getEmail(),
                        registrationDto.getPassword()
                )
        );

        return "";
    }
    /*
    - register method
    - check valid email
    - call sign up method (and get token)

    - send email

     */
}
