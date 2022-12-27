package ru.udisondev.globus.auction.listener;

import org.mapstruct.Mapper;
import ru.udisondev.globus.auction.event.LotInfo;
import ru.udisondev.globus.auction.lot.event.LotEvent;

@Mapper(componentModel = "spring")
public interface AuctionLotMapper {


    LotInfo map(LotEvent event);
}
