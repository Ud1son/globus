package ru.udisondev.globus.claim.service;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.Hazard;

@Value
@Builder
public class CargoInfo {

    String title;
    Integer weight;
    Short placeForCargo;
    Hazard hazard;
    Short size;
    Byte temperatureFrom;
    Byte temperatureTo;
}
