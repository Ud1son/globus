package ru.udisondev.globus.organization.service;

import com.kuliginstepan.dadata.client.domain.organization.Organization;
import org.mapstruct.Mapper;
import ru.udisondev.globus.organization.service.model.ManagementInfo;
import ru.udisondev.globus.organization.service.model.OrganizationInfo;
import ru.udisondev.globus.persistence.enums.BranchType;
import ru.udisondev.globus.persistence.enums.OrganizationStatus;
import ru.udisondev.globus.persistence.enums.OrganizationType;

import static com.kuliginstepan.dadata.client.domain.organization.OrganizationType.LEGAL;

@Mapper(componentModel = "spring")
public interface OrganizationServiceMapper {


    default OrganizationInfo toDto(Organization source) {
        if (source.getType() == LEGAL) {
            return getOrganizationInfoForLegal(source);
        } else {
            return getOrganizationInfoForIndividual(source);
        }
    }

    private OrganizationInfo getOrganizationInfoForIndividual(Organization source) {
        return OrganizationInfo.builder()
                .inn(source.getInn())
                .fullName(source.getName().getFullWithOpf().replaceAll("\"", "'"))
                .shortName(source.getName().getShortWithOpf().replaceAll("\"", "'"))
                .actualityDate(source.getState().getActualityDate())
                .registrationDate(source.getState().getRegistrationDate())
                .okved(source.getOkved())
                .okvedType(source.getOkvedType())
                .address(source.getAddress().getUnrestrictedValue())
                .management(ManagementInfo.builder()
                        .fullName(source.getName().getShortWithOpf().replaceAll("ИП ", ""))
                        .post("Индивидуальный предприниматель")
                        .build())
                .type(OrganizationType.valueOf(source.getType().toString()).getValue())
                .status(OrganizationStatus.valueOf(source.getState().getStatus().toString()).getValue())
                .build();
    }

    private OrganizationInfo getOrganizationInfoForLegal(Organization source) {
        return OrganizationInfo.builder()
                .inn(source.getInn())
                .kpp(source.getKpp())
                .fullName(source.getName().getFullWithOpf().replaceAll("\"", "'"))
                .shortName(source.getName().getShortWithOpf().replaceAll("\"", "'"))
                .actualityDate(source.getState().getActualityDate())
                .registrationDate(source.getState().getRegistrationDate())
                .okved(source.getOkved())
                .okvedType(source.getOkvedType())
                .address(source.getAddress().getUnrestrictedValue())
                .management(ManagementInfo.builder()
                        .fullName(source.getManagement().getName())
                        .post(source.getManagement().getPost())
                        .build())
                .type(OrganizationType.valueOf(source.getType().toString()).getValue())
                .branchType(BranchType.valueOf(source.getBranchType().toString()).getValue())
                .branchCount(source.getBranchCount())
                .status(OrganizationStatus.valueOf(source.getState().getStatus().toString()).getValue())
                .build();
    }

    ru.udisondev.globus.persistence.organization.Organization toEntity(OrganizationInfo organizationInfo);

    OrganizationInfo toDto(ru.udisondev.globus.persistence.organization.Organization save);
}
