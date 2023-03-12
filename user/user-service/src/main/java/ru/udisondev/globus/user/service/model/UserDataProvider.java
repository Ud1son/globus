package ru.udisondev.globus.user.service.model;

import org.jetbrains.annotations.NotNull;
import ru.udisondev.globus.persistence.enums.UserRole;

public interface UserDataProvider {

    @NotNull UserRole getRole();
    @NotNull OrganizationDataProvider getOrganization();
    @NotNull ProfileDataProvider getProfile();
    @NotNull SubscribeDataProvider getSubscribe();
}
