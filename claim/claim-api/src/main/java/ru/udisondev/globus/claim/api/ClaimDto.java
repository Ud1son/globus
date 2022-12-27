package ru.udisondev.globus.claim.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClaimDto {

    String id;
    UUID customerId;
    DeliveryDto delivery;
    CargoDto cargo;
    VehicleDto vehicle;
    BillingDto billing;
}
