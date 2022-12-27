package ru.udisondev.globus.producer.service;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ProducerInfo {

    UUID id;
    UUID userId;
    UUID organizationId;

}
