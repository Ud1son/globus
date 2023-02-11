package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Value
@Builder
public class DeliveryDto {

    LocalDate deliveryDate;
    LocalDate arriveDate;
    String deliveryAddress;
    String arriveAddress;
}
