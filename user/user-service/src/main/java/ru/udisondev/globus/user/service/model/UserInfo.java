package ru.udisondev.globus.user.service.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.UserRole;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class UserInfo {

    UUID id;
    UserRole role;
    ProfileInfo profile;
    OrganizationInfo organization;
    SubscribeInfo subscribe;
    OffsetDateTime registrationDateTime;
    OffsetDateTime lastUpdateDateTime;

}
