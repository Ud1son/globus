package ru.udisondev.globus.exception;

import java.util.UUID;

public class LotNotFoundException extends RuntimeException {

    private LotNotFoundException(String message) {
        super(message);
    }

    public static LotNotFoundException byId(UUID id) {
        return new LotNotFoundException("Lot with id: %s not found!".formatted(id));
    }

    public static LotNotFoundException byClaimId(UUID claimId) {
        return new LotNotFoundException("Lot with claimId: %s not found!".formatted(claimId));
    }
}
