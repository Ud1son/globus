package ru.udisondev.globus.organization.service.model;

import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class OrganizationInfo {

    @Nullable
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
    ManagementInfo management;
    String type;
    String branchType;
    Integer branchCount;
    String status;

}
