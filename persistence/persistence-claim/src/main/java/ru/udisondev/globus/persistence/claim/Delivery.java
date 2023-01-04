package ru.udisondev.globus.persistence.claim;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Embeddable
public class Delivery {

    @Column(nullable = false)
    private OffsetDateTime deliveryFrom;

    @Column(nullable = false)
    private OffsetDateTime deliveryTo;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private String arriveAddress;

}
