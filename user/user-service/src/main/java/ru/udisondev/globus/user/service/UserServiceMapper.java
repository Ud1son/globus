package ru.udisondev.globus.user.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.persistence.enums.UserState;
import ru.udisondev.globus.persistence.user.User;

@Mapper(componentModel = "spring", imports = UserState.class)
public interface UserServiceMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "subscribe.isPaid", defaultValue = "false"),
            @Mapping(target = "registrationDateTime", ignore = true),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
            @Mapping(target = "state", expression = "java(UserState.MODERATION)")
    })
    User toEntity(UserDataProvider userData);

    UserInfo toDto(User save);
}
