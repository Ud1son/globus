package ru.udisondev.globus.claim.service;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;

@Value
@Builder
public class BillingInfo {

    BigDecimal budget;
    BillingType billingType;
}
