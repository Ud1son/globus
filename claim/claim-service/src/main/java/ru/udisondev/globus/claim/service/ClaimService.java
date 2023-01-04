package ru.udisondev.globus.claim.service;

import ru.udisondev.globus.claim.service.model.ClaimDataProvider;
import ru.udisondev.globus.claim.service.model.ClaimInfo;

import java.util.UUID;

public interface ClaimService {

    ClaimInfo create(ClaimDataProvider dataProvider);

    void complete(UUID claimId);

    void cancel(UUID claimId);
}
