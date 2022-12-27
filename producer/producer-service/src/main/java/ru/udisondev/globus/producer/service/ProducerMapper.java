package ru.udisondev.globus.producer.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.persistence.producer.Producer;

@Mapper(componentModel = "spring")
public interface ProducerMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "creationDateTime", ignore = true),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
    })
    Producer toEntity(ProducerDataProvider producer);

    ProducerInfo toDto(Producer producer);
}
