package ru.udisondev.globus.producer.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.producer.service.ProducerDataProvider.DefaultProducerDataProvider;
import ru.udisondev.globus.producer.service.ProducerService;
import ru.udisondev.globus.user.api.UserClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Qualifier("applicationProducerClient")
public class ApplicationProducerClient implements ProducerClient {

    private final ProducerService producerService;
    private final ProducerApiMapper mapper;
    private final UserClient userClient;

    public ApplicationProducerClient(ProducerService producerService,
                                     ProducerApiMapper mapper,
                                     UserClient userClient) {
        this.producerService = producerService;
        this.mapper = mapper;
        this.userClient = userClient;
    }

    @Override
    public ProducerDto create(CreateProducerRequest request) {
        return mapper.toDto(producerService.create(
                DefaultProducerDataProvider.builder()
                        .userId(userClient.create(request.getUserData()).getId())
                .build()));
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
