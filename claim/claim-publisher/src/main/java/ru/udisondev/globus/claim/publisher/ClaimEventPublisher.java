package ru.udisondev.globus.claim.publisher;

import ru.udisondev.globus.claim.event.ClaimEvent;

public interface ClaimEventPublisher {

    void publish(ClaimEvent event);
}
