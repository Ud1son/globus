package ru.udisondev.globus.customer.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CustomerDto {

    UUID id;
    UUID userId;
    UUID organizationId;

}
