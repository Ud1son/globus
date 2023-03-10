package ru.udisondev.globus.auction.lot.service.model;

import ru.udisondev.globus.persistence.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public interface LotDataProvider {

    UUID getClaimId();

    UUID getCustomerId();

    LocalDate getDeliveryDate();

    LocalDate getArriveDate();

    String getDeliveryAddress();

    String getArriveAddress();

    String getTitle();

    Integer getWeight();

    Short getPlaceForCargo();

    Short getSize();

    Hazard getHazard();

    Byte getTemperatureFrom();

    Byte getTemperatureTo();

    VehicleType getVehicleType();

    VehicleSubType getVehicleSubType();

    PlacingType getDeliveryPlacingType();

    PlacingType getArrivePlacingType();

    Short getAmount();

    BigDecimal getBudget();

    BillingType getBillingType();

}
