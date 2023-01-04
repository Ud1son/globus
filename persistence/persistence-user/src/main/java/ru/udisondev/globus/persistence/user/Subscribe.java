package ru.udisondev.globus.persistence.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.SubscribePlan;

import java.time.LocalDate;

@Data
@Embeddable
public class Subscribe {

    private Boolean isPaid;

    private LocalDate finishDate;

    @Enumerated(EnumType.STRING)
    private SubscribePlan plan;

}
