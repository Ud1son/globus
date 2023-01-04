package ru.udisondev.globus.auction.lot.listener;

import org.mapstruct.Mapper;
import ru.udisondev.globus.claim.event.ClaimEvent;

@Mapper(componentModel = "spring")
public interface LotEventMapper {
    LotInfo map(ClaimEvent event);
}
