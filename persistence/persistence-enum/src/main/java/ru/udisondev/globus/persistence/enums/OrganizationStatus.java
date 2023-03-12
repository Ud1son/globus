package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum OrganizationStatus {
    ACTIVE("Активна"),
    LIQUIDATING("Ликвидация"),
    LIQUIDATED("Ликвидирована"),
    BANKRUPT("Банкрот"),
    REORGANIZING("Реорганизация");

    private final String value;

    OrganizationStatus(String value) {
        this.value = value;
    }
}
