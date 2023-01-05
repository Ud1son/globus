package ru.udisondev.globus.customer.service;

import java.util.UUID;

public interface CustomerDataProvider {

    UUID getUserId();
    UUID getOrganizationId();
}
