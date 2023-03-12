package ru.udisondev.globus.user.service.model;

import ru.udisondev.globus.persistence.enums.BranchType;
import ru.udisondev.globus.persistence.enums.OrganizationStatus;
import ru.udisondev.globus.persistence.enums.OrganizationType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrganizationDataProvider {

    UUID getId();
    Long getInn();
    Long getKpp();
    String getOrganizationName();
    String getShortName();
    LocalDate getActualityDate();
    LocalDate getRegistrationDate();
    String getOkved();
    String getOkvedType();
    String getAddress();
    String getManagementFullName();
    String getPost();
    OrganizationType getType();
    BranchType getBranchType();
    Integer getBranchCount();
    OrganizationStatus getStatus();
}
