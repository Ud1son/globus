package ru.udisondev.globus.persistence.bid;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import ru.udisondev.globus.persistence.enums.BidState;
import ru.udisondev.globus.persistence.enums.BillingType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Bid {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, updatable = false)
    private UUID producerId;

    @Column(nullable = false, updatable = false)
    private UUID lotId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private BillingType billingType;

    @Column(nullable = false, updatable = false)
    private BigDecimal bidPrice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BidState state;

    @CreationTimestamp
    private OffsetDateTime creationDateTime;

    @UpdateTimestamp
    private OffsetDateTime lastUpdateDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bid bid = (Bid) o;
        return id != null && Objects.equals(id, bid.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
