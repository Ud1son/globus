package ru.udisondev.globus.organization.api.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class OrganizationDto {

    UUID id;
    String inn;
    String kpp;
    String fullName;
    String shortName;
    LocalDate actualityDate;
    LocalDate registrationDate;
    String okved;
    String okvedType;
    String address;
    ManagementDto management;
    String type;
    String branchType;
    Integer branchCount;
    String status;

}
