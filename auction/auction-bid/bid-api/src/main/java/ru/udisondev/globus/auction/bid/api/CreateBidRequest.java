package ru.udisondev.globus.auction.bid.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.udisondev.globus.auction.bid.service.model.BidDataProvider;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBidRequest implements BidDataProvider {

    private UUID producerId;
    private UUID lotId;
    private BillingType billingType;
    private BigDecimal bidPrice;
}
