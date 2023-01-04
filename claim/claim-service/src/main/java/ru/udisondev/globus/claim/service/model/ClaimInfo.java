package ru.udisondev.globus.claim.service.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClaimInfo {

    UUID claimId;
    Long order;
    UUID customerId;
    DeliveryInfo delivery;
    CargoInfo cargo;
    VehicleInfo vehicle;
    BillingInfo billing;
}
