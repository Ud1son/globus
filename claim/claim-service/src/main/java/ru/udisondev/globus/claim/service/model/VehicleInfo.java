package ru.udisondev.globus.claim.service.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.PlacingType;
import ru.udisondev.globus.persistence.enums.VehicleSubType;
import ru.udisondev.globus.persistence.enums.VehicleType;

@Value
@Builder
public class VehicleInfo {

    VehicleType vehicleType;
    VehicleSubType vehicleSubType;
    PlacingType deliveryPlacingType;
    PlacingType arrivePlacingType;
    Short amount;
}