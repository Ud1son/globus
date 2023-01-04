package ru.udisondev.globus.claim.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.claim.service.model.BillingDataProvider;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;

@Value
@Builder
public class BillingInfo implements BillingDataProvider {

    BigDecimal budget;
    BillingType billingType;
}
