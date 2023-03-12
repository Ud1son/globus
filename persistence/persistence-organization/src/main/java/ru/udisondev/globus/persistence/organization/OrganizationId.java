package ru.udisondev.globus.persistence.organization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrganizationId implements Serializable {

    private String inn;
    private String kpp;
}
