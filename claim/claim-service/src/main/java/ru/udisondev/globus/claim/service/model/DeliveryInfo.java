package ru.udisondev.globus.claim.service.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Value
@Builder
public class DeliveryInfo {

    LocalDate deliveryDate;
    LocalDate arriveDate;
    String deliveryAddress;
    String arriveAddress;
}
