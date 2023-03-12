package ru.udisondev.globus.user.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ContactDto {

    UUID id;
    String firstName;
    String lastName;
    String middleName;
    String phone;
    String email;
}
