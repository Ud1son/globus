package ru.udisondev.globus.user.service;

import org.jetbrains.annotations.NotNull;

public interface UserDataProvider {

    @NotNull ProfileDataProvider getProfile();
    @NotNull SubscribeDataProvider getSubscribe();
}
