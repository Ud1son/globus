package ru.udisondev.globus.user.model;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class UserDto {

    UUID id;
    ProfileDto profile;
    SubscribeDto subscribe;
    OffsetDateTime registrationDateTime;
    OffsetDateTime lastUpdateDateTime;

}
