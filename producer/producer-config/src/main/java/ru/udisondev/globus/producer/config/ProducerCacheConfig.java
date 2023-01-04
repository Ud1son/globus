package ru.udisondev.globus.producer.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class ProducerCacheConfig {

    @Bean(name = ProducerProperties.CACHE_MANAGER_NAME)
    public CacheManager producerCacheManager(ProducerProperties properties) {
        var cacheManager = new SimpleCacheManager();

        var cache = properties.getCache();
        cacheManager.setCaches(
                List.of(
                        new CaffeineCache(
                                ProducerProperties.CACHE_NAME,
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
