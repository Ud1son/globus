package ru.udisondev.globus.producer.service;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.UUID;

public interface ProducerDataProvider {

    UUID getUserId();
    UUID getOrganizationId();

    @Value
    @Builder
    class DefaultProducerDataProvider implements ProducerDataProvider {

        UUID userId;
        UUID organizationId;
    }
}
