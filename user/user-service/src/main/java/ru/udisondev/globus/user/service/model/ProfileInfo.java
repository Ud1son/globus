package ru.udisondev.globus.user.service.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ProfileInfo {

    String firstName;
    String lastName;
    String middleName;
    String phone;
    String email;
    LocalDate birthDay;
}
