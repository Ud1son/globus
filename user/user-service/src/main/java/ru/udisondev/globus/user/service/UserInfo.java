package ru.udisondev.globus.user.service;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class UserInfo {

    UUID id;
    ProfileInfo profile;
    SubscribeInfo subscribe;
    OffsetDateTime registrationDateTime;
    OffsetDateTime lastUpdateDateTime;

}
