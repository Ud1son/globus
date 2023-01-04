package ru.udisondev.globus.claim.api;

import ru.udisondev.globus.claim.model.ClaimDto;

import java.util.UUID;

public interface ClaimClient {

    ClaimDto create(CreateClaimRequest request);

    void cancel(UUID claimId);
}
