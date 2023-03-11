package ru.udisondev.globus.auction.lot.api;

import ru.udisondev.globus.persistence.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class LotDto {

    UUID id;
    LotState state;
    String claimId;
    UUID customerId;
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
