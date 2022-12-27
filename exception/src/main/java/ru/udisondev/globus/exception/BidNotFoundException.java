package ru.udisondev.globus.exception;

import java.util.UUID;

public class BidNotFoundException extends RuntimeException {

    private BidNotFoundException(String message) {
        super(message);
    }

    public static BidNotFoundException byId(UUID id) {
        return new BidNotFoundException("Bid with id: %s not found!".formatted(id));

    }
}
