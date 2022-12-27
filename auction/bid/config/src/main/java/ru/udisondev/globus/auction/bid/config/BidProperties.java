package ru.udisondev.globus.auction.bid.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import ru.udisondev.globus.common.config.Cache;

@Data
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
@ConfigurationProperties(prefix = "app.bid")
public class BidProperties {

    public static final String CACHE_NAME = "bidCache";
    public static final String CACHE_MANAGER_NAME = "bidCacheManager";


    private final Cache cache;
}
