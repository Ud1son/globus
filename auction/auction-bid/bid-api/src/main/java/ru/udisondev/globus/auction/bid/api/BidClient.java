package ru.udisondev.globus.auction.bid.api;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface BidClient {

    BidDto create(@NotNull CreateBidRequest request);

    void approve(UUID bidId);

    void confirm(UUID bidId);

    void reject(UUID bidId);

    void cancel(UUID bidId);
}
