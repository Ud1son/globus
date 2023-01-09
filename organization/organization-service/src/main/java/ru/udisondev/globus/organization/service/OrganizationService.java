package ru.udisondev.globus.organization.service;

import ru.udisondev.globus.organization.service.model.OrganizationInfo;

public interface OrganizationService {

    OrganizationInfo findByInn(String inn);
    OrganizationInfo addOrganization(String inn);
}
