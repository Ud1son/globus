package ru.udisondev.globus.claim.api;

import lombok.Data;
import ru.udisondev.globus.claim.service.model.*;
import ru.udisondev.globus.persistence.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateClaimRequest implements ClaimDataProvider {

    private UUID customerId;
    private CargoInfo cargo;
    private DeliveryInfo delivery;
    private BillingInfo billing;
    private VehicleInfo vehicle;


    @Data
    public static class CargoInfo implements CargoDataProvider {
        private String title;
        private Integer weight;
        private Short placeForCargo;
        private Hazard hazard;
        private Short size;
        private Byte temperatureFrom;
        private Byte temperatureTo;
    }

    @Data
    public static class DeliveryInfo implements DeliveryDataProvider {
        private LocalDate deliveryDate;
        private LocalDate arriveDate;
        private String deliveryAddress;
        private String arriveAddress;
    }

    @Data
    public static class BillingInfo implements BillingDataProvider {
        private BigDecimal budget;
        private BillingType billingType;
    }

    @Data
    public static class VehicleInfo implements VehicleDataProvider {
        private VehicleType vehicleType;
        private VehicleSubType vehicleSubType;
        private PlacingType deliveryPlacingType;
        private PlacingType arrivePlacingType;
        private Short amount;
    }
}