package ru.udisondev.globus.user.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ManagementDto {

    String managementFullName;
    String post;
}
