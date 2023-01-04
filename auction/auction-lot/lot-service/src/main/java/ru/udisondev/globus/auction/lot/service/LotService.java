package ru.udisondev.globus.auction.lot.service;

import ru.udisondev.globus.auction.lot.service.model.LotDataProvider;
import ru.udisondev.globus.auction.lot.service.model.LotInfo;

import java.util.UUID;

public interface LotService {

    LotInfo create(LotDataProvider lotDataProvider);

    void complete(UUID lotId, UUID confirmedBidId);

    void cancel(String claimId);

    LotInfo findLotById(UUID lotId);
}
