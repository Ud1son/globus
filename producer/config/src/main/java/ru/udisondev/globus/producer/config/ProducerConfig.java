package ru.udisondev.globus.producer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ProducerProperties.class)
public class ProducerConfig {
}
