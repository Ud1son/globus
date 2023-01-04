package ru.udisondev.globus.persistence.claim;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.Hazard;

@Data
@Embeddable
public class Cargo {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Short placeForCargo;

    @Column(nullable = false)
    private Short size;

    @Enumerated(EnumType.STRING)
    private Hazard hazard;

    private Byte temperatureFrom;

    private Byte temperatureTo;


}
