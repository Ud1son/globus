package ru.udisondev.globus.exception;

import java.util.UUID;

public class ProducerNotFoundException extends RuntimeException {

    private ProducerNotFoundException(String message) {
        super(message);
    }

    public static ProducerNotFoundException byId(UUID id) {
        return new ProducerNotFoundException("Producer with id: %s not found!".formatted(id));

    }
}
