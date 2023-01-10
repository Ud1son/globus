package ru.udisondev.globus.auction.lot.listener;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.claim.event.ClaimEvent;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-09T22:15:35+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class LotEventMapperImpl implements LotEventMapper {

    @Override
    public LotInfo map(ClaimEvent event) {
        if ( event == null ) {
            return null;
        }

        LotInfo.LotInfoBuilder lotInfo = LotInfo.builder();

        lotInfo.claimId( event.getClaimId() );
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
