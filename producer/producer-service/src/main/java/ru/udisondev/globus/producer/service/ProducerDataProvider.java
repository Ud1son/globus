package ru.udisondev.globus.producer.service;

import java.util.UUID;

public interface ProducerDataProvider {

    UUID getUserId();
    UUID getOrganizationId();
}
