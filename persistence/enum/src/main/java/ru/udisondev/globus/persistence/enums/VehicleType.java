package ru.udisondev.globus.persistence.enums;

import lombok.Getter;

import java.util.List;

@Getter
public enum VehicleType {

    CLOSED(
            "Крытая",
            List.of(
                    VehicleSubType.TENT, VehicleSubType.CELNOMET, VehicleSubType.BUS, VehicleSubType.CONTEINER, VehicleSubType.ODEJDOVOZ, VehicleSubType.IZOTERM, VehicleSubType.REFREJERATOR, VehicleSubType.REF_TUSHEVOZ
            )),
    SPECIAL(
            "Спец. техника",
            List.of(
                    VehicleSubType.AVTOVOZ, VehicleSubType.AVTOVISHKA, VehicleSubType.BETONOVOZ, VehicleSubType.ZERNOVOZ, VehicleSubType.LESOVOZ, VehicleSubType.KONEVOZ, VehicleSubType.KRAN, VehicleSubType.MUSOROVOZ,
                    VehicleSubType.POGRUZCHIK, VehicleSubType.PTICEVOZ, VehicleSubType.SKOTOVOZ, VehicleSubType.STRELOVOZ, VehicleSubType.TRUBOVOZ, VehicleSubType.TYAGACH, VehicleSubType.SHEPOVOZ, VehicleSubType.IVAKUATOR
            )),
    OPENED(
            "Открытая",
            List.of(
                    VehicleSubType.BORTOVAYA, VehicleSubType.PLATFORMA, VehicleSubType.MANIPULATOR, VehicleSubType.LOMOVOZ, VehicleSubType.KONTEINEROVOZ, VehicleSubType.TRAL, VehicleSubType.PLITOVOZ, VehicleSubType.SAMOSVAL
            )),
    PASSENGER(
            "Пассажирская",
            List.of(
                    VehicleSubType.MICRO_AVTOBUS, VehicleSubType.AVTOBUS
            ));

    private final String value;
    private final List<VehicleSubType> subTypes;

    VehicleType(String value, List<VehicleSubType> subTypes) {
        this.value = value;
        this.subTypes = subTypes;
    }
}
