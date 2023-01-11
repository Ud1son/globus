package ru.udisondev.globus.organization.service;

import com.kuliginstepan.dadata.client.DadataClient;
import com.kuliginstepan.dadata.client.DadataClientBuilder;
import com.kuliginstepan.dadata.client.DadataClientProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DadataClientProperties.class)
public class DadataConfig {

    @Bean
    @ConditionalOnMissingBean(DadataClient.class)
    public DadataClient dadataClient(DadataClientProperties clientProperties) {
        return new DadataClientBuilder()
                .clientProperties(clientProperties)
                .build();
    }

}

