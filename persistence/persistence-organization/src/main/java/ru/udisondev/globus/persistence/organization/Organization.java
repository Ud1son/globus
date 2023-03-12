package ru.udisondev.globus.persistence.organization;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import ru.udisondev.globus.persistence.enums.BranchType;
import ru.udisondev.globus.persistence.enums.OrganizationStatus;
import ru.udisondev.globus.persistence.enums.OrganizationType;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private Long inn;

    private Long kpp;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false)
    private String shortName;

    @Column(nullable = false)
    private LocalDate actualityDate;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false)
    private String okved;

    @Column(nullable = false)
    private String okvedType;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Embedded
    private Management management;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrganizationType type;

    @Enumerated(EnumType.STRING)
    private BranchType branchType;

    private Integer branchCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrganizationStatus status;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime createDateTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime lastUpdateDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Organization that = (Organization) o;
        return inn != null && Objects.equals(inn, that.inn)
                && kpp != null && Objects.equals(kpp, that.kpp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inn, kpp);
    }
}
