package ru.udisondev.globus.auction.lot.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLotEventPublisher implements LotEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public ApplicationLotEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publish(LotEvent event) {
        eventPublisher.publishEvent(event);
    }
}
