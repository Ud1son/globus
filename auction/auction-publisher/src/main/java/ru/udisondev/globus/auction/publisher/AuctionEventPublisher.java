package ru.udisondev.globus.auction.publisher;

import ru.udisondev.globus.auction.event.AuctionEvent;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;

public interface AuctionEventPublisher {

    void publish(AuctionEvent event);

    void publishPrivate(PrivateAuctionEvent privateEvent);

}
