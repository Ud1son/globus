package ru.udisondev.globus.persistence.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import ru.udisondev.globus.persistence.enums.UserRole;
import ru.udisondev.globus.persistence.enums.UserState;
import ru.udisondev.globus.persistence.organization.Organization;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "globus_user")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, updatable = false)
    @Enumerated(STRING)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Embedded
    @Column(nullable = false)
    private Profile profile;

    @Embedded
    private Subscribe subscribe;

    @Enumerated(STRING)
    @Column(nullable = false)
    private UserState state;

    @CreationTimestamp
    private OffsetDateTime registrationDateTime;

    @UpdateTimestamp
    private OffsetDateTime lastUpdateDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
