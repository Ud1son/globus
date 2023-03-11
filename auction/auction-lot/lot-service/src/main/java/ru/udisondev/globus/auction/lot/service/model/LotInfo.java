package ru.udisondev.globus.auction.lot.service.model;


import lombok.Builder;
import lombok.Value;
import org.springframework.cglib.core.Local;
import ru.udisondev.globus.persistence.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Value
@Builder
public class LotInfo {

    UUID id;
    @Builder.Default
    LotState state = LotState.OPENED;
    String claimId;
    UUID customerId;
    UUID confirmedBidId;
    LocalDate deliveryDate;
    LocalDate arriveDate;
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
