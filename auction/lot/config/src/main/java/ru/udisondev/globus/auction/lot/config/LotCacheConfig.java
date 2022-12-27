package ru.udisondev.globus.auction.lot.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class LotCacheConfig {

    @Bean(name = LotProperties.CACHE_MANAGER_NAME)
    public CacheManager lotCacheManager(LotProperties properties) {
        var cacheManager = new SimpleCacheManager();
        var cache = properties.getCache();

        cacheManager.setCaches(
                List.of(
                        new CaffeineCache(
                                LotProperties.CACHE_NAME,
                                Caffeine.newBuilder()
                                        .expireAfterWrite(cache.getExpireAfterWriteSec(), SECONDS)
                                        .expireAfterAccess(cache.getExpireAfterAccessSec(), SECONDS)
                                        .initialCapacity(cache.getInitCapacity())
                                        .maximumSize(cache.getMaxSize())
                                        .build()
                        )
                )
        );

        return cacheManager;
    }
}
