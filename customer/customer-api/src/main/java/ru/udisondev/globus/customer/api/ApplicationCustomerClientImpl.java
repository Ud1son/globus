package ru.udisondev.globus.customer.api;

import org.springframework.stereotype.Service;
import ru.udisondev.globus.customer.service.CustomerService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApplicationCustomerClientImpl implements CustomerClient {

    private final CustomerService customerService;
    private final CustomerApiMapper mapper;


    public ApplicationCustomerClientImpl(CustomerService customerService, CustomerApiMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @Override
    public CustomerDto create(CreateCustomerRequest request) {
        return mapper.toDto(customerService.create(request));
    }

    @Override
    public CustomerDto findById(UUID id) {
        return mapper.toDto(customerService.findById(id));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll().stream()
                .parallel()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
