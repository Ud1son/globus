package ru.udisondev.globus.organization.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.organization.api.model.OrganizationDto;
import ru.udisondev.globus.organization.service.model.OrganizationInfo;

@Mapper(componentModel = "spring")
public interface OrganizationApiMapper {

    OrganizationDto toDto(OrganizationInfo source);
}
