package ru.udisondev.globus.organization.service;

import com.kuliginstepan.dadata.client.DadataClient;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.exception.OrganizationIsExistException;
import ru.udisondev.globus.exception.OrganizationNotFoundException;
import ru.udisondev.globus.organization.service.model.OrganizationInfo;
import ru.udisondev.globus.persistence.organization.OrganizationRepository;

import java.util.Optional;
import java.util.function.Function;

import static java.util.Optional.ofNullable;
import static ru.udisondev.globus.organization.config.OrganizationProperties.CACHE_MANAGER_NAME;
import static ru.udisondev.globus.organization.config.OrganizationProperties.CACHE_NAME;

@Service
@CacheConfig(
        cacheNames = CACHE_NAME,
        cacheManager = CACHE_MANAGER_NAME
)
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final DadataClient dadataClient;
    private final OrganizationService organizationService;
    private final OrganizationServiceMapper mapper;


    public OrganizationServiceImpl(OrganizationRepository organizationRepository, DadataClient dadataClient, OrganizationService organizationService, OrganizationServiceMapper mapper) {
        this.organizationRepository = organizationRepository;
        this.dadataClient = dadataClient;
        this.organizationService = organizationService;
        this.mapper = mapper;
    }

    @Cacheable(key = "#a0")
    @Override
    public OrganizationInfo findByInn(String inn) {
        return organizationRepository.findFirstByInn(inn)
                .map(mapper::toDto)
                .orElseGet(() -> ofNullable(dadataClient.findOrganizationById(inn)
                        .map(Suggestion::getData)
                        .map(mapper::toDto)
                        .block())
                        .orElseThrow(() -> OrganizationNotFoundException.byInn(inn)));
    }

    @Override
    public OrganizationInfo addOrganization(String inn) {
        var organizationInfo = organizationService.findByInn(inn);
        if (organizationInfo.getId() != null) {
            return organizationInfo;
        } else {
            return mapper.toDto(organizationRepository.save(mapper.toEntity(organizationInfo)));
        }
    }
}
