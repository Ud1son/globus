package ru.udisondev.globus.organization.service;

import ru.udisondev.globus.organization.service.model.OrganizationInfo;

public interface DadataService {

    OrganizationInfo findByInn(String inn);
}
