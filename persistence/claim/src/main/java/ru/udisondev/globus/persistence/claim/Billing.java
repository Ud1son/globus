package ru.udisondev.globus.persistence.claim;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;

@Data
@Embeddable
public class Billing {

    private BigDecimal budget;
    @Enumerated(EnumType.STRING)
    private BillingType billingType;
}
