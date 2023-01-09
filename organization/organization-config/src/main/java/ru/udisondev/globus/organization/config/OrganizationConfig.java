package ru.udisondev.globus.organization.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OrganizationProperties.class)
public class OrganizationConfig {
}
