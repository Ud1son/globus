package ru.udisondev.globus.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    private UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException byId(UUID id) {
        return new UserNotFoundException("User with id: %s not found!".formatted(id));

    }
}
