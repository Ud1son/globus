package ru.udisondev.globus.claim.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.claim.event.ClaimEvent;

@Component
public class ApplicationClaimEventPublisher implements ClaimEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public ApplicationClaimEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publish(ClaimEvent event) {
        eventPublisher.publishEvent(event);
    }
}
