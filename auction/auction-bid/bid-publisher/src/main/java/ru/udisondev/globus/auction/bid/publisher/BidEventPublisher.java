package ru.udisondev.globus.auction.bid.publisher;

import ru.udisondev.globus.auction.bid.event.BidEvent;

public interface BidEventPublisher {

    void publish(BidEvent event);

}
