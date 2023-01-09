package ru.udisondev.globus.organization.api;

import org.springframework.stereotype.Service;
import ru.udisondev.globus.organization.api.model.OrganizationDto;
import ru.udisondev.globus.organization.service.OrganizationService;

@Service
public class ApplicationOrganizationClient implements OrganizationClient {

    private final OrganizationService organizationService;
    private final OrganizationApiMapper mapper;

    public ApplicationOrganizationClient(OrganizationService organizationService, OrganizationApiMapper mapper) {
        this.organizationService = organizationService;
        this.mapper = mapper;
    }


    @Override
    public OrganizationDto findOrganization(String inn) {
        return mapper.toDto(organizationService.findByInn(inn));
    }

    @Override
    public OrganizationDto addOrganization(String inn) {
        return mapper.toDto(organizationService.addOrganization(inn));
    }
}
