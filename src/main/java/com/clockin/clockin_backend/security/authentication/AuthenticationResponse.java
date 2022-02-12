package com.clockin.clockin_backend.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {
    String token;
    Collection<?> role;
}
