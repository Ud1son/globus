package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum BillingType {

    CASH("Наличный расчет"),
    ACCOUNT("Безналичный расчет без НДС"),
    ACCOUNT_VAT("Безналичный расчет с НДС");

    private final String value;

    BillingType(String value) {
        this.value = value;
    }
}
