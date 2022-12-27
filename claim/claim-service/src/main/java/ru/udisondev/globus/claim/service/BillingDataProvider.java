package ru.udisondev.globus.claim.service;

import org.jetbrains.annotations.NotNull;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;

public interface BillingDataProvider {

    @NotNull BigDecimal getBudget();

    @NotNull BillingType getBillingType();
}
