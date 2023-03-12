package ru.udisondev.globus.user.service.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.BranchType;
import ru.udisondev.globus.persistence.enums.OrganizationStatus;
import ru.udisondev.globus.persistence.enums.OrganizationType;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class OrganizationInfo {

    UUID id;
    Long inn;
    Long kpp;
    String organizationName;
    String shortName;
    LocalDate actualityDate;
    LocalDate registrationDate;
    String okved;
    String okvedType;
    String address;
    ManagementInfo management;
    OrganizationType type;
    BranchType branchType;
    Integer branchCount;
    OrganizationStatus status;

}
