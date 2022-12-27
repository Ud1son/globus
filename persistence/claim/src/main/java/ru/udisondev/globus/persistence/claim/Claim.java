package ru.udisondev.globus.persistence.claim;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.udisondev.globus.persistence.enums.ClaimState;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@IdClass(ClaimId.class)
public class Claim {

    @Id
    private ClaimId id;

    @Column(nullable = false, updatable = false)
    private UUID customerId;

    @Embedded
    private Delivery delivery;

    @Embedded
    @Column(nullable = false)
    private Cargo cargo;

    @Embedded
    @Column(nullable = false)
    private Vehicle vehicle;

    @Embedded
    private Billing billing;

    @Column(nullable = false)
    private ClaimState state;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime lastUpdateDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Claim claim = (Claim) o;
        return id != null && Objects.equals(id, claim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
