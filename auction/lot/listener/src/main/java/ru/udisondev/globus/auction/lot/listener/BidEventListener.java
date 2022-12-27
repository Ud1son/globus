package ru.udisondev.globus.auction.lot.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.auction.lot.service.LotService;

@Component
public class BidEventListener {

    private final LotService lotService;

    public BidEventListener(LotService lotService) {
        this.lotService = lotService;
    }

    @EventListener(condition = "#{event.state.name() == 'CONFIRMED'}")
    public void confirmed(BidEvent event) {
        lotService.complete(event.getLotId(), event.getId());
    }
}
