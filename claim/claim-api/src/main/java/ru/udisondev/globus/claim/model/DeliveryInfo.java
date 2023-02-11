package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.cglib.core.Local;
import ru.udisondev.globus.claim.service.model.DeliveryDataProvider;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Value
@Builder
public class DeliveryInfo implements DeliveryDataProvider {

    LocalDate deliveryDate;
    LocalDate arriveDate;
    String deliveryAddress;
    String arriveAddress;
}
