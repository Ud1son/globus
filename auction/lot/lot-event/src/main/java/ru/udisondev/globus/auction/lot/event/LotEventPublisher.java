package ru.udisondev.globus.auction.lot.event;

public interface LotEventPublisher {

    void publish(LotEvent event);
}
