package ru.udisondev.globus.claim.service;

import org.jetbrains.annotations.NotNull;
import ru.udisondev.globus.persistence.enums.Hazard;

public interface CargoDataProvider {

    @NotNull String getTitle();

    @NotNull Integer getWeight();

    @NotNull Short getPlaceForCargo();

    @NotNull Hazard getHazard();

    @NotNull Short getSize();

    @NotNull Byte getTemperatureFrom();

    @NotNull Byte getTemperatureTo();
}
