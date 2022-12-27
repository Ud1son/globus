package ru.udisondev.globus.claim.api;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.claim.service.BillingDataProvider;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;

@Value
@Builder
public class BillingInfo implements BillingDataProvider {

    BigDecimal budget;
    BillingType billingType;
}
