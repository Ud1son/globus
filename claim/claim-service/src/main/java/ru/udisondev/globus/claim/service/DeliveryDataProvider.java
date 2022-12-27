package ru.udisondev.globus.claim.service;

import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public interface DeliveryDataProvider {

    @NotNull OffsetDateTime getDeliveryFrom();

    @NotNull OffsetDateTime getDeliveryTo();

    @NotNull String getDeliveryAddress();

    @NotNull String getArriveAddress();
}
