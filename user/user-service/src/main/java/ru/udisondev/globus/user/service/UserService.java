package ru.udisondev.globus.user.service;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface UserService {

    UserInfo create(@NotNull UserDataProvider userData);
    UserInfo findById(@NotNull UUID id);
}
