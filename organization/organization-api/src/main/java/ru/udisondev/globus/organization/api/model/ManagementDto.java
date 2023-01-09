package ru.udisondev.globus.organization.api.model;

import lombok.Builder;

public record ManagementDto(
        String fullName,
        String post
) {
    @Builder public ManagementDto {}
}
