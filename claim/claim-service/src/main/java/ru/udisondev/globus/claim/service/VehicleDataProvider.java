package ru.udisondev.globus.claim.service;

import org.jetbrains.annotations.NotNull;
import ru.udisondev.globus.persistence.enums.PlacingType;
import ru.udisondev.globus.persistence.enums.VehicleSubType;
import ru.udisondev.globus.persistence.enums.VehicleType;

public interface VehicleDataProvider {

    @NotNull VehicleType getVehicleType();

    @NotNull VehicleSubType getVehicleSubType();

    @NotNull PlacingType getDeliveryPlacingType();

    @NotNull PlacingType getArrivePlacingType();

    @NotNull Short getAmount();
}
