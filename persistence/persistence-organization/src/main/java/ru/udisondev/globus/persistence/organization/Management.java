package ru.udisondev.globus.persistence.organization;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Management {

    @Column(nullable = false)
    private String managementFullName;
    @Column(nullable = false)
    private String post;

}
