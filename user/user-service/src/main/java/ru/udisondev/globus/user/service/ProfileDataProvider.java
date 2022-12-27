package ru.udisondev.globus.user.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public interface ProfileDataProvider {

    @NotNull String getFirstName();
    @NotNull String getLastName();
    @Nullable String getMiddleName();
    @NotNull String getPhone();
    @NotNull String getEmail();
    @Nullable LocalDate getBirthDay();
}
