package ru.udisondev.globus.claim.service;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface ClaimDataProvider {

    @NotNull UUID getCustomerId();

    @NotNull CargoDataProvider getCargo();

    @NotNull DeliveryDataProvider getDelivery();

    @NotNull BillingDataProvider getBilling();

    @NotNull VehicleDataProvider getVehicle();
}
