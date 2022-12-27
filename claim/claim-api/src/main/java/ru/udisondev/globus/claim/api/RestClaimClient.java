package ru.udisondev.globus.claim.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import ru.udisondev.globus.claim.service.ClaimService;

@RestController
@ConditionalOnProperty(prefix = "app", name = "client", havingValue = "REST")
@RequestMapping("/claim")
public class RestClaimClient implements ClaimClient {

    private final ClaimService claimService;
    private final ClaimApiMapper mapper;

    public RestClaimClient(ClaimService claimService, ClaimApiMapper mapper) {
        this.claimService = claimService;
        this.mapper = mapper;
    }

    @Override
    @PostMapping
    public ClaimDto create(@RequestBody CreateClaimRequest request) {
        return mapper.toResponse(claimService.create(request));
    }

    @Override
    @PostMapping("/cancel/{claimId}")
    public void cancel(@PathVariable("claimId") String claimId) {
        claimService.cancel(claimId);
    }
}
