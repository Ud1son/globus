package ru.udisondev.globus.producer.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.udisondev.globus.organization.api.OrganizationClient;
import ru.udisondev.globus.producer.service.ProducerDataProvider;
import ru.udisondev.globus.producer.service.ProducerService;
import ru.udisondev.globus.user.api.UserClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producer")
@Qualifier("restProducerClient")
public class RestProducerClient implements ProducerClient {

    private final ProducerService producerService;
    private final ProducerApiMapper mapper;
    private final OrganizationClient organizationClient;
    private final UserClient userClient;

    public RestProducerClient(ProducerService producerService,
                                     ProducerApiMapper mapper,
                                     OrganizationClient organizationClient,
                                     UserClient userClient) {
        this.producerService = producerService;
        this.mapper = mapper;
        this.organizationClient = organizationClient;
        this.userClient = userClient;
    }

    @Override
    @PostMapping
    public ProducerDto create(@RequestBody CreateProducerRequest request) {
        return mapper.toDto(producerService.create(
                ProducerDataProvider.DefaultProducerDataProvider.builder()
                        .organizationId(organizationClient.addOrganization(request.getOrganizationInn()).getId())
                        .userId(userClient.create(request.getUserData()).getId())
                        .build()));
    }

    @Override
    @GetMapping("/{id}")
    public ProducerDto findById(@PathVariable("id") UUID id) {
        return mapper.toDto(producerService.findById(id));
    }

    @Override
    @GetMapping
    public List<ProducerDto> findAll() {
        return producerService.findAll().stream()
                .parallel()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
