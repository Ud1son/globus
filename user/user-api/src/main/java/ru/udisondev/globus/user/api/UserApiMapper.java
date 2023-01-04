package ru.udisondev.globus.user.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.user.model.UserDto;
import ru.udisondev.globus.user.service.UserInfo;

@Mapper(componentModel = "spring")
public interface UserApiMapper {
    UserDto toDto(UserInfo userInfo);
}
