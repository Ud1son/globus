package ru.udisondev.globus.customer.api;

import java.util.List;
import java.util.UUID;

public interface CustomerClient {

    CustomerDto create(CreateCustomerRequest request);

    CustomerDto findById(UUID id);

    List<CustomerDto> findAll();
}
