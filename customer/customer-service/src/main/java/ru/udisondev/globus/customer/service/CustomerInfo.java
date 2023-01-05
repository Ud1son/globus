package ru.udisondev.globus.customer.service;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CustomerInfo {

    UUID id;
    UUID userId;
    UUID organizationId;

}
