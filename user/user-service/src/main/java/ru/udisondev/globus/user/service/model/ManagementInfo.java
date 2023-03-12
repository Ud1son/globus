package ru.udisondev.globus.user.service.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ManagementInfo {

    String managementFullName;
    String post;
}
