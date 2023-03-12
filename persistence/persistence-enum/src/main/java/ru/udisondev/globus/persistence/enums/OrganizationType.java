package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum OrganizationType {
    LEGAL("Юридическое лицо"), INDIVIDUAL("Индивидуальный предприниматель");

    private final String value;

    OrganizationType(String value) {
        this.value = value;
    }
}
