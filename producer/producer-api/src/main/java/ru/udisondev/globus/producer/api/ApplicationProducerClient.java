package ru.udisondev.globus.producer.api;

import org.springframework.stereotype.Service;
import ru.udisondev.globus.organization.api.OrganizationClient;
import ru.udisondev.globus.producer.service.ProducerDataProvider;
import ru.udisondev.globus.producer.service.ProducerDataProvider.DefaultProducerDataProvider;
import ru.udisondev.globus.producer.service.ProducerService;
import ru.udisondev.globus.user.api.UserClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApplicationProducerClient implements ProducerClient {

    private final ProducerService producerService;
    private final ProducerApiMapper mapper;
    private final OrganizationClient organizationClient;
    private final UserClient userClient;

    public ApplicationProducerClient(ProducerService producerService,
                                     ProducerApiMapper mapper,
                                     OrganizationClient organizationClient,
                                     UserClient userClient) {
        this.producerService = producerService;
        this.mapper = mapper;
        this.organizationClient = organizationClient;
        this.userClient = userClient;
    }

    @Override
    public ProducerDto create(CreateProducerRequest request) {
        return mapper.toDto(producerService.create(
                DefaultProducerDataProvider.builder()
                        .organizationId(organizationClient.addOrganization(request.getOrganizationInn()).getId())
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
