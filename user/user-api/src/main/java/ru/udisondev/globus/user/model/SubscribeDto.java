package ru.udisondev.globus.user.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.SubscribePlan;

import java.time.LocalDate;

@Value
@Builder
public class SubscribeDto {

    Boolean isPaid;
    LocalDate finishDate;
    SubscribePlan plan;

}
