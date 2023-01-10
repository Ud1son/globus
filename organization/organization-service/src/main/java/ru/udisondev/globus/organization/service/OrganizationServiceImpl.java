package ru.udisondev.globus.organization.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import ru.udisondev.globus.exception.OrganizationNotFoundException;
import ru.udisondev.globus.organization.service.model.OrganizationInfo;
import ru.udisondev.globus.persistence.organization.OrganizationRepository;

import static java.util.Optional.of;
import static ru.udisondev.globus.organization.config.OrganizationProperties.CACHE_MANAGER_NAME;
import static ru.udisondev.globus.organization.config.OrganizationProperties.CACHE_NAME;

@Service
@CacheConfig(
        cacheNames = CACHE_NAME,
        cacheManager = CACHE_MANAGER_NAME
)
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationServiceMapper mapper;
    private final DadataService dadataService;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationServiceMapper mapper, DadataService dadataService) {
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
        this.dadataService = dadataService;
    }

    @Override
    public OrganizationInfo findByInn(String inn) {
        return dadataService.findByInn(inn);
    }

    @Override
    public OrganizationInfo addOrganization(String inn) {
        return organizationRepository.findFirstByInn(inn)
                .map(mapper::toDto)
                .orElseGet(() -> of(dadataService.findByInn(inn))
                        .map(mapper::toEntity)
                        .map(organizationRepository::save)
                        .map(mapper::toDto)
                        .orElseThrow(() -> OrganizationNotFoundException.byInn(inn)));
    }
}
