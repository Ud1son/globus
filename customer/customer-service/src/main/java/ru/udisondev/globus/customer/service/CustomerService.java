package ru.udisondev.globus.customer.service;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerInfo create(CustomerDataProvider customer);

    CustomerInfo findById(UUID id);

    List<CustomerInfo> findAll();
}
