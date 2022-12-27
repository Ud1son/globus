package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum Hazard {

    A("1 класс"),
    B("2 класс"),
    C("3 класс"),
    D("4 класс"),
    E("5 класс"),
    F("6 класс"),
    G("7 класс"),
    H("8 класс"),
    I("9 класс");

    private final String value;

    Hazard(String value) {
        this.value = value;
    }

}
