package ru.udisondev.globus.claim.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.claim.model.ClaimDto;
import ru.udisondev.globus.claim.service.ClaimService;

import java.util.UUID;

@Service
@ConditionalOnMissingBean(ClaimClient.class)
public class ApplicationClaimClient implements ClaimClient {

    private final ClaimService claimService;
    private final ClaimApiMapper mapper;

    public ApplicationClaimClient(ClaimService claimService, ClaimApiMapper mapper) {
        this.claimService = claimService;
        this.mapper = mapper;
    }

    @Override
    public ClaimDto create(CreateClaimRequest request) {
        return mapper.toResponse(claimService.create(request));
    }

    @Override
    public void cancel(UUID claimId) {
        claimService.cancel(claimId);
    }
}
