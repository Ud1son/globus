package ru.udisondev.globus.user.api;

import java.util.UUID;

public interface UserClient {

    UserDto create(CreateUserRequest request);

    UserDto findById(UUID id);
}
