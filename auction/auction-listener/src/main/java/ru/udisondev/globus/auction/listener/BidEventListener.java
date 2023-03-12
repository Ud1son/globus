package ru.udisondev.globus.auction.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.auction.lot.api.LotClient;
import ru.udisondev.globus.auction.publisher.AuctionEventPublisher;
import ru.udisondev.globus.persistence.enums.AuctionState;

@Component("auctionBidEventListener")
public class BidEventListener {

    private final LotClient lotClient;
    private final AuctionEventMapper mapper;
    private final AuctionEventPublisher eventPublisher;

    public BidEventListener(LotClient lotClient, AuctionEventMapper mapper, AuctionEventPublisher eventPublisher) {
        this.lotClient = lotClient;
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
    }

    @EventListener(condition = "#event.state.name() == 'REQUESTED'")
    public void requested(BidEvent event) {
        var lot = lotClient.findById(event.getLotId());
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        lot.getCustomerId(),
                        event,
                        lot,
                        AuctionState.BID_REQUESTED));
    }

    @EventListener(condition = "#event.state.name() == 'APPROVED'")
    public void approved(BidEvent event) {
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        event.getProducerId(),
                        event,
                        lotClient.findById(event.getLotId()),
                        AuctionState.BID_APPROVED));
    }

    @EventListener(condition = "#event.state.name() == 'REJECTED'")
    public void rejected(BidEvent event) {
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        event.getProducerId(),
                        event,
                        lotClient.findById(event.getLotId()),
                        AuctionState.BID_REJECTED));
    }

    @EventListener(condition = "#event.state.name() == 'CONFIRNED'")
    public void confirmed(BidEvent event) {
        var lot = lotClient.findById(event.getLotId());
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        lot.getCustomerId(),
                        event,
                        lot,
                        AuctionState.BID_CONFIRMED));
    }

    @EventListener(condition = "#event.state.name() == 'CLOSED'")
    public void closed(BidEvent event) {
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        event.getProducerId(),
                        event,
                        lotClient.findById(event.getLotId()),
                        AuctionState.BID_CLOSED));
    }

    @EventListener(condition = "#event.state.name() == 'CANCELLED'")
    public void cancelled(BidEvent event) {
        var lot = lotClient.findById(event.getLotId());
        eventPublisher.publishPrivate(
                mapper.toPrivateEvent(
                        lot.getCustomerId(),
                        event,
                        lot,
                        AuctionState.BID_CANCELLED));
    }

}
