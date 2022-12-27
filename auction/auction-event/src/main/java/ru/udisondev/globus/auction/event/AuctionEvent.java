package ru.udisondev.globus.auction.event;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import ru.udisondev.globus.persistence.enums.AuctionState;

@Data
@SuperBuilder
public class AuctionEvent {

    protected final BidInfo bidInfo;
    protected final LotInfo lotInfo;
    protected final AuctionState eventType;

}
