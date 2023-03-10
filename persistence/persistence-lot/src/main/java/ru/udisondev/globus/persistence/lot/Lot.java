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
import java.time.LocalDate;
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

    @Column(columnDefinition = "serial",
            insertable = false,
            updatable = false,
            unique = true)
    private Long lotOrder;

    @Enumerated(EnumType.STRING)
    private LotState state;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID claimId;

    @Column(nullable = false, updatable = false)
    private UUID customerId;

    private UUID confirmedBidId;

    @Column(nullable = false)
    private LocalDate deliveryDate;

    @Column(nullable = false)
    private LocalDate arriveDate;

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

    @Enumerated(EnumType.STRING)
    private PlacingType deliveryPlacingType;

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
