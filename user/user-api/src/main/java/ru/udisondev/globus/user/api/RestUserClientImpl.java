package ru.udisondev.globus.user.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import ru.udisondev.globus.user.model.CreateUserRequest;
import ru.udisondev.globus.user.model.UserDto;
import ru.udisondev.globus.user.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@ConditionalOnProperty(prefix = "app", name = "client", havingValue = "REST")
public class RestUserClientImpl implements UserClient {

    private final UserService userService;
    private final UserApiMapper mapper;

    public RestUserClientImpl(UserService userService, UserApiMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    @PostMapping
    public UserDto create(@RequestBody CreateUserRequest request) {
        return mapper.toDto(userService.create(request));
    }

    @Override
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") UUID id) {
        return mapper.toDto(userService.findById(id));
    }
}
