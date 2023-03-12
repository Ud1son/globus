package ru.udisondev.globus.auction.lot.service;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.auction.lot.event.LotEvent;
import ru.udisondev.globus.auction.lot.service.model.LotDataProvider;
import ru.udisondev.globus.auction.lot.service.model.LotInfo;
import ru.udisondev.globus.persistence.enums.LotState;
import ru.udisondev.globus.persistence.lot.Lot;

@Mapper(componentModel = "spring", imports = LotState.class)
public interface LotMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "lotOrder", ignore = true),
            @Mapping(target = "creationDateTime", ignore = true),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
            @Mapping(target = "confirmedBidId", ignore = true),
            @Mapping(target = "state", expression = "java(LotState.OPENED)")
    })
    Lot toEntity(LotDataProvider lotDataProvider);

    LotEvent toEvent(Lot lot);

    LotInfo toDto(Lot lot);
}
