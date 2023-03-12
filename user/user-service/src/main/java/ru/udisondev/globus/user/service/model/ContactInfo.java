package ru.udisondev.globus.user.service.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ContactInfo {

    UUID id;
    String firstName;
    String lastName;
    String middleName;
    String phone;
    String email;

}
