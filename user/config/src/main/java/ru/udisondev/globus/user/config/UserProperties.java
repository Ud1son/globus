package ru.udisondev.globus.user.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import ru.udisondev.globus.common.config.Cache;

@Data
@ConfigurationProperties(prefix = "app.user")
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
public class UserProperties {

    public static final String CACHE_NAME = "userCache";
    public static final String CACHE_MANAGER_NAME = "userCacheManager";
    @NotNull
    private final Cache cache;
}
