package ru.udisondev.globus.user.service;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import ru.udisondev.globus.user.service.model.UserDataProvider;
import ru.udisondev.globus.user.service.model.UserInfo;

import java.util.List;
import java.util.UUID;

@Validated
public interface UserService {

    UserInfo create(@NotNull UserDataProvider userData);
    UserInfo findById(@NotNull UUID id);

    List<UserInfo> findAllProducers();
}
