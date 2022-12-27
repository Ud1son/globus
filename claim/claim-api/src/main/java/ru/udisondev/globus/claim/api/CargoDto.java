package ru.udisondev.globus.claim.api;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.Hazard;

@Value
@Builder
public class CargoDto {

    String title;
    Integer weight;
    Short placeForCargo;
    Hazard hazard;
    Short size;
    Byte temperatureFrom;
    Byte temperatureTo;
}
