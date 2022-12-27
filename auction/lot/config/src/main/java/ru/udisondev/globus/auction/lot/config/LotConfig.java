package ru.udisondev.globus.auction.lot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LotProperties.class)
public class LotConfig {
}
