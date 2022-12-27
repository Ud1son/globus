package ru.udisondev.globus.producer.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.producer.service.ProducerInfo;

@Mapper(componentModel = "spring")
public interface ProducerApiMapper {
    ProducerDto toDto(ProducerInfo producerInfo);
}
