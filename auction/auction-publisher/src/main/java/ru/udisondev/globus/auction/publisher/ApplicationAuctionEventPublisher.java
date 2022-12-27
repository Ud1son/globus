package ru.udisondev.globus.auction.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.event.AuctionEvent;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;

@Component
public class ApplicationAuctionEventPublisher implements AuctionEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public ApplicationAuctionEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publish(AuctionEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void publishPrivate(PrivateAuctionEvent privateEvent) {
        eventPublisher.publishEvent(privateEvent);
    }
}
