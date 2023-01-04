package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.claim.service.model.CargoDataProvider;
import ru.udisondev.globus.persistence.enums.Hazard;

@Value
@Builder
public class CargoInfo implements CargoDataProvider {

    String title;
    Integer weight;
    Short placeForCargo;
    Hazard hazard;
    Short size;
    Byte temperatureFrom;
    Byte temperatureTo;
}
