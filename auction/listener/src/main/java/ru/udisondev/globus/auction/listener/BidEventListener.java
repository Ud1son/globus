package ru.udisondev.globus.auction.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.auction.lot.service.LotService;
import ru.udisondev.globus.auction.publisher.AuctionEventPublisher;
import ru.udisondev.globus.persistence.enums.AuctionState;

@Component
public class BidEventListener {

    private final LotService lotService;
    private final AuctionEventMapper mapper;
    private final AuctionEventPublisher eventPublisher;

    public BidEventListener(LotService lotService, AuctionEventMapper mapper, AuctionEventPublisher eventPublisher) {
        this.lotService = lotService;
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
    }

    @EventListener(condition = "#{event.state.name() == 'REQUESTED'}")
    public void requested(BidEvent event) {
        var lot = lotService.findLotById(event.getLotId());
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        lot.getCustomerId(),
                        event,
                        lot,
                        AuctionState.BID_REQUESTED));
    }

    @EventListener(condition = "#{event.state.name() == 'APPROVED'}")
    public void approved(BidEvent event) {
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        event.getProducerId(),
                        event,
                        lotService.findLotById(event.getLotId()),
                        AuctionState.BID_APPROVED));
    }

    @EventListener(condition = "#{event.state.name() == 'REJECTED'}")
    public void rejected(BidEvent event) {
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        event.getProducerId(),
                        event,
                        lotService.findLotById(event.getLotId()),
                        AuctionState.BID_REJECTED));
    }

    @EventListener(condition = "#{event.state.name() == 'CONFIRNED'}")
    public void confirmed(BidEvent event) {
        var lot = lotService.findLotById(event.getLotId());
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        lot.getCustomerId(),
                        event,
                        lot,
                        AuctionState.BID_CONFIRMED));
    }

    @EventListener(condition = "#{event.state.name() == 'CLOSED'}")
    public void closed(BidEvent event) {
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        event.getProducerId(),
                        event,
                        lotService.findLotById(event.getLotId()),
                        AuctionState.BID_CLOSED));
    }

    @EventListener(condition = "#{event.state.name() == 'CANCELLED'}")
    public void cancelled(BidEvent event) {
        var lot = lotService.findLotById(event.getLotId());
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        lot.getCustomerId(),
                        event,
                        lot,
                        AuctionState.BID_CANCELLED));
    }

}
