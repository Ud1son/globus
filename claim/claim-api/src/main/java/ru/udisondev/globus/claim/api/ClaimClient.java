package ru.udisondev.globus.claim.api;

public interface ClaimClient {

    ClaimDto create(CreateClaimRequest request);

    void cancel(String claimId);
}
