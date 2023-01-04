package ru.udisondev.globus.auction.bid.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.service.BidService;
import ru.udisondev.globus.auction.lot.event.LotEvent;

@Component("bidLotEventListener")
public class LotEventListener {

    private final BidService bidService;

    public LotEventListener(BidService bidService) {
        this.bidService = bidService;
    }

    @EventListener(condition = "#event.state.name() == 'CANCELLED'")
    public void cancelled(LotEvent event) {
        bidService.closeAllByLotId(event.getId());
    }

    @EventListener(condition = "#event.state.name() == 'COMPLETED'")
    public void completed(LotEvent event) {
        bidService.closeAllByLotIdExcludeConfirmed(event.getId(), event.getConfirmedBidId());
    }
}
