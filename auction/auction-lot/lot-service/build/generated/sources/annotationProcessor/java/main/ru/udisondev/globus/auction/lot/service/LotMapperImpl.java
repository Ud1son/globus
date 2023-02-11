package ru.udisondev.globus.auction.lot.service;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.lot.event.LotEvent;
import ru.udisondev.globus.auction.lot.service.model.LotDataProvider;
import ru.udisondev.globus.auction.lot.service.model.LotInfo;
import ru.udisondev.globus.persistence.enums.LotState;
import ru.udisondev.globus.persistence.lot.Lot;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T20:12:57+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class LotMapperImpl implements LotMapper {

    @Override
    public Lot toEntity(LotDataProvider lotDataProvider) {
        if ( lotDataProvider == null ) {
            return null;
        }

        Lot lot = new Lot();

        lot.setClaimId( lotDataProvider.getClaimId() );
        lot.setCustomerId( lotDataProvider.getCustomerId() );
        lot.setDeliveryFrom( lotDataProvider.getDeliveryFrom() );
        lot.setDeliveryTo( lotDataProvider.getDeliveryTo() );
        lot.setDeliveryAddress( lotDataProvider.getDeliveryAddress() );
        lot.setArriveAddress( lotDataProvider.getArriveAddress() );
        lot.setTitle( lotDataProvider.getTitle() );
        lot.setWeight( lotDataProvider.getWeight() );
        lot.setHazard( lotDataProvider.getHazard() );
        lot.setPlaceForCargo( lotDataProvider.getPlaceForCargo() );
        lot.setSize( lotDataProvider.getSize() );
        lot.setTemperatureFrom( lotDataProvider.getTemperatureFrom() );
        lot.setTemperatureTo( lotDataProvider.getTemperatureTo() );
        lot.setVehicleType( lotDataProvider.getVehicleType() );
        lot.setVehicleSubType( lotDataProvider.getVehicleSubType() );
        lot.setDeliveryPlacingType( lotDataProvider.getDeliveryPlacingType() );
        lot.setArrivePlacingType( lotDataProvider.getArrivePlacingType() );
        lot.setAmount( lotDataProvider.getAmount() );
        lot.setBudget( lotDataProvider.getBudget() );
        lot.setBillingType( lotDataProvider.getBillingType() );

        lot.setState( LotState.OPENED );

        return lot;
    }

    @Override
    public LotEvent toEvent(Lot lot) {
        if ( lot == null ) {
            return null;
        }

        LotEvent.LotEventBuilder lotEvent = LotEvent.builder();

        lotEvent.id( lot.getId() );
        lotEvent.state( lot.getState() );
        if ( lot.getClaimId() != null ) {
            lotEvent.claimId( UUID.fromString( lot.getClaimId() ) );
        }
        lotEvent.customerId( lot.getCustomerId() );
        lotEvent.confirmedBidId( lot.getConfirmedBidId() );
        lotEvent.deliveryFrom( lot.getDeliveryFrom() );
        lotEvent.deliveryTo( lot.getDeliveryTo() );
        lotEvent.deliveryAddress( lot.getDeliveryAddress() );
        lotEvent.arriveAddress( lot.getArriveAddress() );
        lotEvent.title( lot.getTitle() );
        lotEvent.weight( lot.getWeight() );
        lotEvent.placeForCargo( lot.getPlaceForCargo() );
        lotEvent.size( lot.getSize() );
        lotEvent.hazard( lot.getHazard() );
        lotEvent.temperatureFrom( lot.getTemperatureFrom() );
        lotEvent.temperatureTo( lot.getTemperatureTo() );
        lotEvent.vehicleType( lot.getVehicleType() );
        lotEvent.vehicleSubType( lot.getVehicleSubType() );
        lotEvent.deliveryPlacingType( lot.getDeliveryPlacingType() );
        lotEvent.arrivePlacingType( lot.getArrivePlacingType() );
        lotEvent.amount( lot.getAmount() );
        lotEvent.budget( lot.getBudget() );
        lotEvent.billingType( lot.getBillingType() );

        return lotEvent.build();
    }

    @Override
    public LotInfo toDto(Lot lot) {
        if ( lot == null ) {
            return null;
        }

        LotInfo.LotInfoBuilder lotInfo = LotInfo.builder();

        lotInfo.id( lot.getId() );
        lotInfo.state( lot.getState() );
        lotInfo.claimId( lot.getClaimId() );
        lotInfo.customerId( lot.getCustomerId() );
        lotInfo.confirmedBidId( lot.getConfirmedBidId() );
        lotInfo.deliveryFrom( lot.getDeliveryFrom() );
        lotInfo.deliveryTo( lot.getDeliveryTo() );
        lotInfo.deliveryAddress( lot.getDeliveryAddress() );
        lotInfo.arriveAddress( lot.getArriveAddress() );
        lotInfo.title( lot.getTitle() );
        lotInfo.weight( lot.getWeight() );
        lotInfo.placeForCargo( lot.getPlaceForCargo() );
        lotInfo.size( lot.getSize() );
        lotInfo.hazard( lot.getHazard() );
        lotInfo.temperatureFrom( lot.getTemperatureFrom() );
        lotInfo.temperatureTo( lot.getTemperatureTo() );
        lotInfo.vehicleType( lot.getVehicleType() );
        lotInfo.vehicleSubType( lot.getVehicleSubType() );
        lotInfo.deliveryPlacingType( lot.getDeliveryPlacingType() );
        lotInfo.arrivePlacingType( lot.getArrivePlacingType() );
        lotInfo.amount( lot.getAmount() );
        lotInfo.budget( lot.getBudget() );
        lotInfo.billingType( lot.getBillingType() );

        return lotInfo.build();
    }
}
