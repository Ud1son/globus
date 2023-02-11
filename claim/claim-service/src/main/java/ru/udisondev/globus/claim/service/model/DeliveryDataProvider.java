package ru.udisondev.globus.claim.service.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public interface DeliveryDataProvider {

    @NotNull LocalDate getDeliveryDate();

    @NotNull LocalDate getArriveDate();

    @NotNull String getDeliveryAddress();

    @NotNull String getArriveAddress();
}
