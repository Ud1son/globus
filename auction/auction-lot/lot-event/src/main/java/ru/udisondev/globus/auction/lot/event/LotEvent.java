package ru.udisondev.globus.auction.lot.event;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.*;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class LotEvent {

    UUID id;
    LotState state;
    UUID claimId;
    UUID customerId;
    @Nullable
    UUID confirmedBidId;
    OffsetDateTime deliveryFrom;
    OffsetDateTime deliveryTo;
    String deliveryAddress;
    String arriveAddress;
    String title;
    Integer weight;
    Short placeForCargo;
    Short size;
    Hazard hazard;
    Byte temperatureFrom;
    Byte temperatureTo;
    VehicleType vehicleType;
    VehicleSubType vehicleSubType;
    PlacingType deliveryPlacingType;
    PlacingType arrivePlacingType;
    Short amount;
    BigDecimal budget;
    BillingType billingType;
}
