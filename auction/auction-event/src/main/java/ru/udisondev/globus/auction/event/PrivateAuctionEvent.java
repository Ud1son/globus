package ru.udisondev.globus.auction.event;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class PrivateAuctionEvent extends AuctionEvent {

    UUID eventReceiver;

}
