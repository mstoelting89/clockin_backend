package com.clockin.clockin_backend.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtTokenResponse {
    private String token;
}
