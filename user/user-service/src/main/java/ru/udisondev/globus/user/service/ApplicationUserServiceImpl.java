package ru.udisondev.globus.user.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.exception.UserNotFoundException;
import ru.udisondev.globus.persistence.enums.UserRole;
import ru.udisondev.globus.persistence.user.UserRepository;
import ru.udisondev.globus.user.config.UserProperties;
import ru.udisondev.globus.user.service.model.UserDataProvider;
import ru.udisondev.globus.user.service.model.UserInfo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static ru.udisondev.globus.persistence.enums.UserRole.PRODUCER;

@Service
@CacheConfig(
        cacheNames = UserProperties.CACHE_NAME,
        cacheManager = UserProperties.CACHE_MANAGER_NAME
)
public class ApplicationUserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserServiceMapper mapper;

    public ApplicationUserServiceImpl(UserRepository repository, UserServiceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @CachePut(key = "#{result.id}")
    public UserInfo create(UserDataProvider userData) {
        return mapper.toDto(repository.save(mapper.toEntity(userData)));
    }

    @Cacheable
    public UserInfo findById(UUID id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> UserNotFoundException.byId(id)));
    }

    @Override
    public List<UserInfo> findAllProducers() {
        return repository.findAllByRole(PRODUCER).stream()
                .parallel()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
