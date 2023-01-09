package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum BranchType {
    MAIN("Головной офис"), BRANCH("Филиал");

    private final String value;

    BranchType(String value) {
        this.value = value;
    }
}
