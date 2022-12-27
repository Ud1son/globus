package ru.udisondev.globus.persistence.user;

import jakarta.persistence.Embeddable;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.SubscribePlan;

import java.time.LocalDate;

@Data
@Embeddable
public class Subscribe {

    private Boolean isPaid;
    private LocalDate finishDate;
    private SubscribePlan plan;

}
