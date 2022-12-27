package ru.udisondev.globus.auction.bid.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.event.BidEvent;

@Component
public class ApplicationBidEventPublisher implements BidEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public ApplicationBidEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publish(BidEvent event) {
        eventPublisher.publishEvent(event);
    }


}
