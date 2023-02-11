package ru.udisondev.globus.customer.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.customer.service.CustomerDataProvider.DefaultCustomerDataProvider;
import ru.udisondev.globus.customer.service.CustomerService;
import ru.udisondev.globus.user.api.UserClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@ConditionalOnMissingBean(CustomerClient.class)
public class ApplicationCustomerClientImpl implements CustomerClient {

    private final CustomerService customerService;
    private final CustomerApiMapper mapper;
    private final UserClient userClient;


    public ApplicationCustomerClientImpl(CustomerService customerService,
                                         CustomerApiMapper mapper,
                                         UserClient userClient) {
        this.customerService = customerService;
        this.mapper = mapper;
        this.userClient = userClient;
    }

    @Override
    public CustomerDto create(CreateCustomerRequest request) {
        return mapper.toDto(
                customerService.create(
                        DefaultCustomerDataProvider.builder()
                                .userId(userClient.create(request.getUserData()).getId())
                                .build()
                )
        );
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
