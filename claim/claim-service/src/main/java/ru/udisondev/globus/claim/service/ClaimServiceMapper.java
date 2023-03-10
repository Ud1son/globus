package ru.udisondev.globus.claim.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.udisondev.globus.claim.event.ClaimEvent;
import ru.udisondev.globus.claim.service.model.ClaimDataProvider;
import ru.udisondev.globus.claim.service.model.ClaimInfo;
import ru.udisondev.globus.persistence.claim.Claim;
import ru.udisondev.globus.persistence.enums.ClaimState;

@Mapper(componentModel = "spring", imports = ClaimState.class)
public interface ClaimServiceMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "claimOrder", ignore = true),
            @Mapping(target = "creationDateTime", ignore = true),
            @Mapping(target = "lastUpdateDateTime", ignore = true),
            @Mapping(target = "state", expression = "java(ClaimState.NEW)")
    })
    Claim toEntity(ClaimDataProvider dataProvider);

    @Mappings({
            @Mapping(target = "claimId", source = "id"),
            @Mapping(target = "deliveryDate", source = "delivery.deliveryDate"),
            @Mapping(target = "arriveDate", source = "delivery.arriveDate"),
            @Mapping(target = "deliveryAddress", source = "delivery.deliveryAddress"),
            @Mapping(target = "arriveAddress", source = "delivery.arriveAddress"),
            @Mapping(target = "title", source = "cargo.title"),
            @Mapping(target = "weight", source = "cargo.weight"),
            @Mapping(target = "placeForCargo", source = "cargo.placeForCargo"),
            @Mapping(target = "size", source = "cargo.size"),
            @Mapping(target = "hazard", source = "cargo.hazard"),
            @Mapping(target = "temperatureFrom", source = "cargo.temperatureFrom"),
            @Mapping(target = "temperatureTo", source = "cargo.temperatureTo"),
            @Mapping(target = "vehicleType", source = "vehicle.vehicleType"),
            @Mapping(target = "vehicleSubType", source = "vehicle.vehicleSubType"),
            @Mapping(target = "deliveryPlacingType", source = "vehicle.deliveryPlacingType"),
            @Mapping(target = "arrivePlacingType", source = "vehicle.arrivePlacingType"),
            @Mapping(target = "amount", source = "vehicle.amount"),
            @Mapping(target = "budget", source = "billing.budget"),
            @Mapping(target = "billingType", source = "billing.billingType"),
    })
    ClaimEvent toEvent(Claim claim);

    @Mapping(target = "order", source = "claimOrder")
    @Mapping(target = "claimId", source = "id")
    ClaimInfo toDto(Claim claim);
}
