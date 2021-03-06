package com.clockin.clockin_backend.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticationDto {
    private String email;
    private String password;
}
