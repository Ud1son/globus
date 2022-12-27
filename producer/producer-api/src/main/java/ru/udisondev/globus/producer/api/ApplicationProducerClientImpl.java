package ru.udisondev.globus.producer.api;

import org.springframework.stereotype.Service;
import ru.udisondev.globus.producer.service.ProducerService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApplicationProducerClientImpl implements ProducerClient {

    private final ProducerService producerService;
    private final ProducerApiMapper mapper;

    public ApplicationProducerClientImpl(ProducerService producerService, ProducerApiMapper mapper) {
        this.producerService = producerService;
        this.mapper = mapper;
    }

    @Override
    public ProducerDto create(CreateProducerRequest request) {
        return mapper.toDto(producerService.create(request));
    }

    @Override
    public ProducerDto findById(UUID id) {
        return mapper.toDto(producerService.findById(id));
    }

    @Override
    public List<ProducerDto> findAll() {
        return producerService.findAll().stream()
                .parallel()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
