package ru.udisondev.globus.claim.api;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.claim.service.DeliveryDataProvider;

import java.time.OffsetDateTime;

@Value
@Builder
public class DeliveryInfo implements DeliveryDataProvider {

    OffsetDateTime deliveryFrom;
    OffsetDateTime deliveryTo;
    String deliveryAddress;
    String arriveAddress;
}
