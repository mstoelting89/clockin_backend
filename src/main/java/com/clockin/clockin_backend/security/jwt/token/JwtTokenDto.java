package com.clockin.clockin_backend.security.jwt.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JwtTokenDto {
    private String token;
}
