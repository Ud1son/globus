package ru.udisondev.globus.customer.service;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

public interface CustomerDataProvider {

    UUID getUserId();
    UUID getOrganizationId();

    @Value
    @Builder
    class DefaultCustomerDataProvider implements CustomerDataProvider {

        UUID userId;
        UUID organizationId;
    }
}
