package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClaimDto {

    UUID claimId;
    Long order;
    UUID customerId;
    DeliveryDto delivery;
    CargoDto cargo;
    VehicleDto vehicle;
    BillingDto billing;
}
