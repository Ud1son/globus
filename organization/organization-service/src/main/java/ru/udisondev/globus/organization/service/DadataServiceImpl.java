package ru.udisondev.globus.organization.service;

import com.kuliginstepan.dadata.client.DadataClient;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.organization.service.model.OrganizationInfo;

import static ru.udisondev.globus.organization.config.OrganizationProperties.CACHE_MANAGER_NAME;
import static ru.udisondev.globus.organization.config.OrganizationProperties.CACHE_NAME;

@Service
@CacheConfig(
        cacheNames = CACHE_NAME,
        cacheManager = CACHE_MANAGER_NAME
)
public class DadataServiceImpl implements DadataService {

    private final DadataClient dadataClient;
    private final OrganizationServiceMapper mapper;

    public DadataServiceImpl(DadataClient dadataClient, OrganizationServiceMapper mapper) {
        this.dadataClient = dadataClient;
        this.mapper = mapper;
    }

    @Cacheable(key = "#a0")
    @Override
    public OrganizationInfo findByInn(String inn) {
        return dadataClient.findOrganizationById(inn)
                        .map(Suggestion::getData)
                        .map(mapper::toDto)
                        .block();
    }
}
