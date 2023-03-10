package ru.udisondev.globus.auction.bid.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.auction.bid.service.model.BidInfo;

@Mapper(componentModel = "spring")
public interface BidApiMapper {

    BidDto toResponse(BidInfo source);

}
