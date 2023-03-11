package ru.udisondev.globus.persistence.claim;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.PlacingType;
import ru.udisondev.globus.persistence.enums.VehicleSubType;
import ru.udisondev.globus.persistence.enums.VehicleType;

@Data
@Embeddable
public class Vehicle {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleSubType vehicleSubType;

    @Column(nullable = false)    @Enumerated(EnumType.STRING)
    private PlacingType deliveryPlacingType;

    @Enumerated(EnumType.STRING)
    private PlacingType arrivePlacingType;

    @Column(nullable = false)
    private Short amount;

}
