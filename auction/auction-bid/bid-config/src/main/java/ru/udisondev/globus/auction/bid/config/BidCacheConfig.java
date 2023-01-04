package ru.udisondev.globus.auction.bid.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class BidCacheConfig {

    @Bean(name = BidProperties.CACHE_MANAGER_NAME)
    public CacheManager bidCacheManager(BidProperties properties) {
        var cache = properties.getCache();

        var cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(
                List.of(
                   new CaffeineCache(
                           BidProperties.CACHE_NAME,
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
