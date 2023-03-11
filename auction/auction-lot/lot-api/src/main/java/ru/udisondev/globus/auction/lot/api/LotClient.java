package ru.udisondev.globus.auction.lot.api;

import java.util.UUID;

public interface LotClient {

    LotDto findById(UUID id);
}
