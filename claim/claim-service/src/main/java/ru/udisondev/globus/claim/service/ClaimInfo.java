package ru.udisondev.globus.claim.service;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClaimInfo {

    String id;
    UUID customerId;
    DeliveryInfo delivery;
    CargoInfo cargo;
    VehicleInfo vehicle;
    BillingInfo billing;
}
