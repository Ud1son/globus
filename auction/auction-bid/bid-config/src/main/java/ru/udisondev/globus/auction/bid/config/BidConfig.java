package ru.udisondev.globus.auction.bid.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BidProperties.class)
public class BidConfig {
}
