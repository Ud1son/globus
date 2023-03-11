package ru.udisondev.globus.auction.lot.api;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationLotClient implements LotClient {



    @Override
    public LotDto findById(UUID id) {
        return null;
    }
}
