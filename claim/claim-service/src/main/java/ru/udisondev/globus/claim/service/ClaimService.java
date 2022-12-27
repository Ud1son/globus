package ru.udisondev.globus.claim.service;

public interface ClaimService {

    ClaimInfo create(ClaimDataProvider dataProvider);

    void complete(String claimId);

    void cancel(String claimId);
}
