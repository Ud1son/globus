package ru.udisondev.globus.organization.service.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ManagementInfo {

    String fullName;
    String post;

}
