package ru.udisondev.globus.exception;

public class ClaimNotFoundException extends RuntimeException {

    private ClaimNotFoundException(String message) {
        super(message);
    }

    public static ClaimNotFoundException byId(String id) {
        return new ClaimNotFoundException("Claim with id: %s not found!".formatted(id));

    }

}
