package ru.udisondev.globus.user.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.user.service.UserService;

import java.util.UUID;

@Service
@ConditionalOnMissingBean(UserClient.class)
public class ApplicationUserClientImpl implements UserClient {

    private final UserService userService;
    private final UserApiMapper mapper;

    public ApplicationUserClientImpl(UserService userService, UserApiMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public UserDto create(CreateUserRequest request) {
        return mapper.toDto(userService.create(request));
    }

    @Override
    public UserDto findById(UUID id) {
        return mapper.toDto(userService.findById(id));
    }
}
