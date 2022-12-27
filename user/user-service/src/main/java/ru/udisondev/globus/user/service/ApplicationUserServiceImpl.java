package ru.udisondev.globus.user.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.exception.UserNotFoundException;
import ru.udisondev.globus.persistence.user.UserRepository;
import ru.udisondev.globus.user.config.UserProperties;

import java.util.UUID;

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
}
