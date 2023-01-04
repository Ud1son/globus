package ru.udisondev.globus.exception;

import java.util.UUID;

public class ClaimNotFoundException extends RuntimeException {

    private ClaimNotFoundException(String message) {
        super(message);
    }

    public static ClaimNotFoundException byId(UUID id) {
        return new ClaimNotFoundException("Claim with id: %s not found!".formatted(id));

    }

}
