package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum PlacingType {

    TOP("Верхняя"),
    SIDE("Боковая"),
    REAR("Задняя"),
    FULL_TENTING("Полная растентовка");

    private final String value;

    PlacingType(String value) {
        this.value = value;
    }
}
