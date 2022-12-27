package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

@Getter
public enum VehicleSubType {

    TENT("Тент"),
    CELNOMET("Цельномет"),
    BUS("Бус"),
    CONTEINER("Контейнер"),
    ODEJDOVOZ("Одеждовоз"),
    IZOTERM("Изотерм"),
    REFREJERATOR("Рефрежератор"),
    REF_TUSHEVOZ("Реф. тушевоз"),
    AVTOVOZ("Автовоз"),
    AVTOVISHKA("Автовышка"),
    BETONOVOZ("Бетоновоз"),
    ZERNOVOZ("Зерновоз"),
    LESOVOZ("Лесовоз"),
    KONEVOZ("Коневоз"),
    KRAN("Кран"),
    MUSOROVOZ("Мусоровоз"),
    POGRUZCHIK("Погрузчик"),
    PTICEVOZ("Птицевоз"),
    SKOTOVOZ("Скотовоз"),
    STRELOVOZ("Стреловоз"),
    TRUBOVOZ("Трубовоз"),
    TYAGACH("Тягач"),
    SHEPOVOZ("Щеповоз"),
    IVAKUATOR("Эвакуатор"),
    BORTOVAYA("Бортовоя"),
    PLATFORMA("Платформа"),
    MANIPULATOR("Манипулятор"),
    LOMOVOZ("Ломовоз"),
    KONTEINEROVOZ("Контейнеровоз"),
    TRAL("Трал"),
    PLITOVOZ("Плитовоз"),
    SAMOSVAL("Самосвал"),
    MICRO_AVTOBUS("Микроавтобус"),
    AVTOBUS("Автобус");

    private final String value;

    VehicleSubType(String value) {
        this.value = value;
    }
}
