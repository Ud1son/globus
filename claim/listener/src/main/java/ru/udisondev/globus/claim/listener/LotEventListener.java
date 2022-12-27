package ru.udisondev.globus.claim.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.lot.event.LotEvent;
import ru.udisondev.globus.claim.service.ClaimService;

@Component
public class LotEventListener {

    private final ClaimService claimService;

    public LotEventListener(ClaimService claimService) {
        this.claimService = claimService;
    }

    @EventListener(condition = "#{event.state.name() == 'COMPLETED'}")
    public void completed(LotEvent event) {
        claimService.complete(event.getClaimId());
    }
}
