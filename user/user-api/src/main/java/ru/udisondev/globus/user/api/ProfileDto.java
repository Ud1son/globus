package ru.udisondev.globus.user.api;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ProfileDto {

    String firstName;
    String lastName;
    String middleName;
    String phone;
    String email;
    LocalDate birthDay;
}
