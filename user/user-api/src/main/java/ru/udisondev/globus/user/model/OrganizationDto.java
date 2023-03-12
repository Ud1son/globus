package ru.udisondev.globus.user.model;

import lombok.Builder;
import lombok.Value;
import ru.udisondev.globus.persistence.enums.BranchType;
import ru.udisondev.globus.persistence.enums.OrganizationStatus;
import ru.udisondev.globus.persistence.enums.OrganizationType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class OrganizationDto {

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
    ManagementDto management;
    OrganizationType type;
    BranchType branchType;
    Integer branchCount;
    OrganizationStatus status;
}
