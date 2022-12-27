package ru.udisondev.globus.producer.api;

import java.util.List;
import java.util.UUID;

public interface ProducerClient {

    ProducerDto create(CreateProducerRequest request);

    ProducerDto findById(UUID id);

    List<ProducerDto> findAll();
}
