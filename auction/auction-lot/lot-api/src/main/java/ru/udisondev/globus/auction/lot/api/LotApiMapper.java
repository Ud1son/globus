package ru.udisondev.globus.auction.lot.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.auction.lot.service.model.LotInfo;

@Mapper(componentModel = "spring")
public interface LotApiMapper {

    LotDto map(LotInfo lotById);
}
