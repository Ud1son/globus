package ru.udisondev.globus.user.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.*;
import ru.udisondev.globus.user.service.model.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateUserRequest implements UserDataProvider {

    @NotNull
    private UserRole role;
    @NotNull
    private OrganizationInfo organization;
    @NotNull
    private ProfileInfo profile;
    @NotNull
    private SubscribeInfo subscribe;

    @Data
    public static class OrganizationInfo implements OrganizationDataProvider {

        private UUID id;
        private Long inn;
        private Long kpp;
        private String organizationName;
        private String shortName;
        private LocalDate actualityDate;
        private LocalDate registrationDate;
        private String okved;
        private String okvedType;
        private String address;
        private String managementFullName;
        private String post;
        private OrganizationType type;
        private BranchType branchType;
        private Integer branchCount;
        private OrganizationStatus status;

    }


    @Data
    public static class ProfileInfo implements ProfileDataProvider {

        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;
        private String middleName;
        @NotBlank
        private String phone;
        @NotBlank
        private String email;
        private LocalDate birthDay;
    }

    @Data
    public static class SubscribeInfo implements SubscribeDataProvider {

        private Boolean isPaid;
        private LocalDate finishDate;
        @NotNull
        private SubscribePlan plan;

    }
}
