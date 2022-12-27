package ru.udisondev.globus.auction.lot.service;

import java.util.UUID;

public interface LotService {

    LotInfo create(LotDataProvider lotDataProvider);

    void complete(UUID lotId, UUID confirmedBidId);

    void cancel(String claimId);

    LotInfo findLotById(UUID lotId);
}
