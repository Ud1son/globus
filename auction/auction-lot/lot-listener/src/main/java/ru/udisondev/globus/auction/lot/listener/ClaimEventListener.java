package ru.udisondev.globus.auction.lot.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.lot.service.LotService;
import ru.udisondev.globus.claim.event.ClaimEvent;

@Component
public class ClaimEventListener {

    private final LotService lotService;
    private final LotEventMapper mapper;

    public ClaimEventListener(LotService lotService, LotEventMapper mapper) {
        this.lotService = lotService;
        this.mapper = mapper;
    }

    @EventListener(condition = "#event.state.name() == 'NEW'")
    public void newClaim(ClaimEvent event) {
        lotService.create(mapper.map(event));
    }

    @EventListener(condition = "#event.state.name() == 'CANCELLED'")
    public void cancelled(ClaimEvent event) {
        lotService.cancel(event.getClaimId());
    }
}
