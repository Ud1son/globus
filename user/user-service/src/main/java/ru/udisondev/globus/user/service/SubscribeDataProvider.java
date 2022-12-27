package ru.udisondev.globus.user.service;

import ru.udisondev.globus.persistence.enums.SubscribePlan;

import java.time.LocalDate;

public interface SubscribeDataProvider {

    Boolean getIsPaid();
    LocalDate getFinishDate();
    SubscribePlan getPlan();
}
