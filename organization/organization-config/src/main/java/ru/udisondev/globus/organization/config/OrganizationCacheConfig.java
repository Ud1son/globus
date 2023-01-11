package ru.udisondev.globus.organization.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class OrganizationCacheConfig {

    @Bean(name = OrganizationProperties.CACHE_MANAGER_NAME)
    public CacheManager producerCacheManager(OrganizationProperties properties) {
        var cacheManager = new SimpleCacheManager();

        var cache = properties.getCache();
        cacheManager.setCaches(
                List.of(
                        new CaffeineCache(
                                OrganizationProperties.CACHE_NAME,
                                Caffeine.newBuilder()
                                        .expireAfterAccess(cache.getExpireAfterAccessSec(), SECONDS)
                                        .expireAfterWrite(cache.getExpireAfterWriteSec(), SECONDS)
                                        .initialCapacity(cache.getInitCapacity())
                                        .maximumSize(cache.getMaxSize())
                                .build())
                )
        );
        return cacheManager;
    }
}