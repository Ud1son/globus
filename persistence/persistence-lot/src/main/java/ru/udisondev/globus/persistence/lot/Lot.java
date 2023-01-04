package ru.udisondev.globus.persistence.lot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import ru.udisondev.globus.persistence.enums.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Lot {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Enumerated(EnumType.STRING)
    private LotState state;

    @Column(nullable = false, unique = true, updatable = false)
    private String claimId;

    @Column(nullable = false, updatable = false)
    private UUID customerId;

    private UUID confirmedBidId;

    @Column(nullable = false)
    private OffsetDateTime deliveryFrom;

    @Column(nullable = false)
    private OffsetDateTime deliveryTo;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private String arriveAddress;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer weight;

    @Enumerated(EnumType.STRING)
    private Hazard hazard;

    @Column(nullable = false)
    private Short placeForCargo;

    @Column(nullable = false)
    private Short size;

    private Byte temperatureFrom;

    private Byte temperatureTo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleSubType vehicleSubType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlacingType deliveryPlacingType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlacingType arrivePlacingType;

    @Column(nullable = false)
    private Short amount;

    private BigDecimal budget;

    @Enumerated(EnumType.STRING)
    private BillingType billingType;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime lastUpdateDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lot lot = (Lot) o;
        return id != null && Objects.equals(id, lot.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
