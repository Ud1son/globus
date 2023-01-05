package ru.udisondev.globus.customer.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.customer.config.CustomerProperties;
import ru.udisondev.globus.exception.ProducerNotFoundException;
import ru.udisondev.globus.persistence.customer.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@CacheConfig(
        cacheNames = CustomerProperties.CACHE_NAME,
        cacheManager = CustomerProperties.CACHE_MANAGER_NAME
)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    @CachePut(key = "#{result.id}")
    public CustomerInfo create(CustomerDataProvider customer) {
        var savedProducer = repository.save(mapper.toEntity(customer));
        return mapper.toDto(savedProducer);
    }

    @Override
    @Cacheable
    public CustomerInfo findById(UUID id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> ProducerNotFoundException.byId(id)));
    }

    @Override
    @Cacheable
    public List<CustomerInfo> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

    }
}
