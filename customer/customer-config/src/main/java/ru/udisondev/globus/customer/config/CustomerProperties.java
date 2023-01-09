package ru.udisondev.globus.customer.config;

import config.Cache;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Data
@ConfigurationProperties(prefix = "app.customer")
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
public class CustomerProperties {

    public static final String CACHE_NAME = "customerCache";
    public static final String CACHE_MANAGER_NAME = "customerCacheManager";
    @NotNull
    private final Cache cache;
}
