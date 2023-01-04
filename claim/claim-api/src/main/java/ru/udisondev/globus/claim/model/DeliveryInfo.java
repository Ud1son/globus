package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.claim.service.model.DeliveryDataProvider;

import java.time.OffsetDateTime;

@Value
@Builder
public class DeliveryInfo implements DeliveryDataProvider {

    OffsetDateTime deliveryFrom;
    OffsetDateTime deliveryTo;
    String deliveryAddress;
    String arriveAddress;
}
