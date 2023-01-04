package ru.udisondev.globus.auction.bid.service.model;

import org.jetbrains.annotations.NotNull;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;
import java.util.UUID;

public interface BidDataProvider {

    @NotNull UUID getProducerId();

    @NotNull UUID getLotId();

    @NotNull BillingType getBillingType();

    @NotNull BigDecimal getBidPrice();

}
