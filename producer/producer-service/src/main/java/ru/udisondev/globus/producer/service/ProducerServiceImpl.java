package ru.udisondev.globus.producer.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.exception.ProducerNotFoundException;
import ru.udisondev.globus.persistence.producer.ProducerRepository;
import ru.udisondev.globus.producer.config.ProducerProperties;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@CacheConfig(
        cacheNames = ProducerProperties.CACHE_NAME,
        cacheManager = ProducerProperties.CACHE_MANAGER_NAME
)
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository repository;
    private final ProducerMapper mapper;


    public ProducerServiceImpl(ProducerRepository repository, ProducerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    @CachePut(key = "#{result.id}")
    public ProducerInfo create(ProducerDataProvider producer) {
        var savedProducer = repository.save(mapper.toEntity(producer));
        return mapper.toDto(savedProducer);
    }

    @Override
    @Cacheable
    public ProducerInfo findById(UUID id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> ProducerNotFoundException.byId(id)));
    }

    @Override
    @Cacheable
    public List<ProducerInfo> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

    }
}
