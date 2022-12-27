package ru.udisondev.globus.claim.api;

import org.mapstruct.Mapper;
import ru.udisondev.globus.claim.service.ClaimInfo;

@Mapper(componentModel = "spring")
public interface ClaimApiMapper {
    ClaimDto toResponse(ClaimInfo claimInfo);
}
