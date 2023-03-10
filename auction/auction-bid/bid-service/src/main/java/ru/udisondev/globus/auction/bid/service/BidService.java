package ru.udisondev.globus.auction.bid.service;

import ru.udisondev.globus.auction.bid.service.model.BidDataProvider;
import ru.udisondev.globus.auction.bid.service.model.BidInfo;

import java.util.UUID;

public interface  BidService {

    BidInfo create(BidDataProvider bidDataProvider);

    void approve(UUID id);

    void confirm(UUID id);

    void closeAllByLotId(UUID id);

    void closeAllByLotIdExcludeConfirmed(UUID id, UUID confirmedBidId);

    void reject(UUID bidId);

    void cancel(UUID bidId);
}
