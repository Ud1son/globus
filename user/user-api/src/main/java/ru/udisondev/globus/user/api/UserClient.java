package ru.udisondev.globus.user.api;

import ru.udisondev.globus.user.model.CreateUserRequest;
import ru.udisondev.globus.user.model.UserDto;

import java.util.UUID;

public interface UserClient {

    UserDto create(CreateUserRequest request);

    UserDto findById(UUID id);
}
