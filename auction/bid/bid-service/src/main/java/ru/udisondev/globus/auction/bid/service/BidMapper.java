package ru.udisondev.globus.auction.bid.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.persistence.bid.Bid;
import ru.udisondev.globus.persistence.enums.BidState;

@Mapper(componentModel = "spring", imports = BidState.class)
public interface BidMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "creationDateTime", ignore = true),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
            @Mapping(target = "state", expression = "java(BidState.REQUESTED)")
    })
    Bid toEntry(BidDataProvider bidDataProvider);

    BidEvent toEvent(Bid bid);

    BidInfo toDto(Bid bid);
}
