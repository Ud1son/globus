package ru.udisondev.globus.auction.lot.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import ru.udisondev.globus.common.config.Cache;

@Data
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
@ConfigurationProperties(prefix = "app.lot")
public class LotProperties {

    public static final String CACHE_NAME = "lotCache";
    public static final String CACHE_MANAGER_NAME = "lotCacheManager";

    @NotNull
    private final Cache cache;

}
