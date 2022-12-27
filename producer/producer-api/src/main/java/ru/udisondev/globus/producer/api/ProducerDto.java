package ru.udisondev.globus.producer.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ProducerDto {

    UUID id;
    UUID userId;
    UUID organizationId;

}
