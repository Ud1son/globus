package ru.udisondev.globus.user.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.UserRole;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class UserDto {

    UUID id;
    UserRole role;
    OrganizationDto organization;
    ProfileDto profile;
    SubscribeDto subscribe;
    OffsetDateTime registrationDateTime;
    OffsetDateTime lastUpdateDateTime;

}
