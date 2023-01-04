package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
@Builder
public class DeliveryDto {

    OffsetDateTime deliveryFrom;
    OffsetDateTime deliveryTo;
    String deliveryAddress;
    String arriveAddress;
}
