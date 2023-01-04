package ru.udisondev.globus.auction.listener;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.auction.event.AuctionEvent;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.auction.lot.service.model.LotInfo;
import ru.udisondev.globus.persistence.enums.AuctionState;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AuctionEventMapper {

    @Mappings({
            @Mapping(target = "lotInfo.", source = "lot"),
            @Mapping(target = "bidInfo.", source = "event")
    })
    AuctionEvent toEvent(BidEvent event, LotInfo lot, AuctionState eventType);

    @Mappings({
            @Mapping(target = "eventReceiver", source = "eventReceiver"),
            @Mapping(target = "lotInfo.", source = "lot"),
            @Mapping(target = "bidInfo.", source = "event")
    })
    PrivateAuctionEvent toPrivateEvent(UUID eventReceiver, BidEvent event, LotInfo lot, AuctionState eventType);


}
