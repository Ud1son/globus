package ru.udisondev.globus.auction.listener;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.event.LotInfo;
import ru.udisondev.globus.auction.lot.event.LotEvent;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T22:15:34+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class AuctionLotMapperImpl implements AuctionLotMapper {

    @Override
    public LotInfo map(LotEvent event) {
        if ( event == null ) {
            return null;
        }

        LotInfo.LotInfoBuilder lotInfo = LotInfo.builder();

        lotInfo.id( event.getId() );
        lotInfo.state( event.getState() );
        if ( event.getClaimId() != null ) {
            lotInfo.claimId( event.getClaimId().toString() );
        }
        lotInfo.customerId( event.getCustomerId() );
        lotInfo.deliveryFrom( event.getDeliveryFrom() );
        lotInfo.deliveryTo( event.getDeliveryTo() );
        lotInfo.deliveryAddress( event.getDeliveryAddress() );
        lotInfo.arriveAddress( event.getArriveAddress() );
        lotInfo.title( event.getTitle() );
        lotInfo.weight( event.getWeight() );
        lotInfo.placeForCargo( event.getPlaceForCargo() );
        lotInfo.size( event.getSize() );
        lotInfo.hazard( event.getHazard() );
        lotInfo.temperatureFrom( event.getTemperatureFrom() );
        lotInfo.temperatureTo( event.getTemperatureTo() );
        lotInfo.vehicleType( event.getVehicleType() );
        lotInfo.vehicleSubType( event.getVehicleSubType() );
        lotInfo.deliveryPlacingType( event.getDeliveryPlacingType() );
        lotInfo.arrivePlacingType( event.getArrivePlacingType() );
        lotInfo.amount( event.getAmount() );
        lotInfo.budget( event.getBudget() );
        lotInfo.billingType( event.getBillingType() );

        return lotInfo.build();
    }
}
