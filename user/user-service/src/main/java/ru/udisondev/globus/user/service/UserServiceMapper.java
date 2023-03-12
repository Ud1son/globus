package ru.udisondev.globus.user.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.persistence.enums.UserState;
import ru.udisondev.globus.persistence.user.User;
import ru.udisondev.globus.user.service.model.UserDataProvider;
import ru.udisondev.globus.user.service.model.UserInfo;

@Mapper(componentModel = "spring", imports = UserState.class)
public interface UserServiceMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "subscribe.isPaid", defaultValue = "false"),
            @Mapping(target = "registrationDateTime", ignore = true),
            @Mapping(target = "organization.createDateTime", ignore = true),
            @Mapping(target = "organization.management.post", source = "organization.post"),
            @Mapping(target = "organization.management.managementFullName", source = "organization.managementFullName"),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
            @Mapping(target = "organization.lastUpdateDateTime", ignore = true),
            @Mapping(target = "state", expression = "java(UserState.MODERATION)")
    })
    User toEntity(UserDataProvider userData);

    UserInfo toDto(User save);
}
