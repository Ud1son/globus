package ru.udisondev.globus.user.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.udisondev.globus.persistence.enums.SubscribePlan;
import ru.udisondev.globus.user.service.ProfileDataProvider;
import ru.udisondev.globus.user.service.SubscribeDataProvider;
import ru.udisondev.globus.user.service.UserDataProvider;

import java.time.LocalDate;

@Data
public class CreateUserRequest implements UserDataProvider {

    @NotNull
    private ProfileInfo profile;
    @NotNull
    private SubscribeInfo subscribe;

    @Data
    public static class ProfileInfo implements ProfileDataProvider {

        @NotBlank
        private String firstName;
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
