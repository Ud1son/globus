package ru.udisondev.globus.auction.bid.service.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.BidState;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class BidInfo {

    UUID id;
    UUID producerId;
    UUID lotId;
    BillingType billingType;
    BigDecimal bidPrice;
    BidState state;
}
