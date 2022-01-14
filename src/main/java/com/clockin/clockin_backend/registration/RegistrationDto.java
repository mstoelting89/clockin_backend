package com.clockin.clockin_backend.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
