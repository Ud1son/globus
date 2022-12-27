package ru.udisondev.globus.producer.service;

import java.util.List;
import java.util.UUID;

public interface ProducerService {

    ProducerInfo create(ProducerDataProvider producer);

    ProducerInfo findById(UUID id);

    List<ProducerInfo> findAll();
}
