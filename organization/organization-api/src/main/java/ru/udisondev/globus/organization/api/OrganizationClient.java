package ru.udisondev.globus.organization.api;

import ru.udisondev.globus.organization.api.model.OrganizationDto;

public interface OrganizationClient {

    OrganizationDto findOrganization(String inn);

    OrganizationDto addOrganization(String inn);

}
