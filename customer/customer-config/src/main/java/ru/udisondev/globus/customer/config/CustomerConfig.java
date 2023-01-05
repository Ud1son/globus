package ru.udisondev.globus.customer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomerProperties.class)
public class CustomerConfig {
}
