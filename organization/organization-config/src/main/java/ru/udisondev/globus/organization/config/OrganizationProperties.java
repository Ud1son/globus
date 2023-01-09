package ru.udisondev.globus.organization.config;

import config.Cache;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Data
@ConfigurationProperties(prefix = "app.organization")
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
public class OrganizationProperties {

    public static final String CACHE_NAME = "organizationCache";
    public static final String CACHE_MANAGER_NAME = "organizationCacheManager";
    @NotNull
    private final Cache cache;
}
