package ru.udisondev.globus.auction.listener;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.auction.event.AuctionEvent;
import ru.udisondev.globus.auction.event.BidInfo;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.auction.lot.service.model.LotInfo;
import ru.udisondev.globus.persistence.enums.AuctionState;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T11:59:47+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class AuctionEventMapperImpl implements AuctionEventMapper {

    @Override
    public AuctionEvent toEvent(BidEvent event, LotInfo lot, AuctionState eventType) {
        if ( event == null && lot == null && eventType == null ) {
            return null;
        }

        AuctionEvent.AuctionEventBuilder<?, ?> auctionEvent = AuctionEvent.builder();

        auctionEvent.bidInfo( bidEventToBidInfo( event ) );
        auctionEvent.lotInfo( lotInfoToLotInfo( lot ) );
        auctionEvent.eventType( eventType );

        return auctionEvent.build();
    }

    @Override
    public PrivateAuctionEvent toPrivateEvent(UUID eventReceiver, BidEvent event, LotInfo lot, AuctionState eventType) {
        if ( eventReceiver == null && event == null && lot == null && eventType == null ) {
            return null;
        }

        PrivateAuctionEvent.PrivateAuctionEventBuilder<?, ?> privateAuctionEvent = PrivateAuctionEvent.builder();

        privateAuctionEvent.eventReceiver( eventReceiver );
        privateAuctionEvent.bidInfo( bidEventToBidInfo( event ) );
        privateAuctionEvent.lotInfo( lotInfoToLotInfo( lot ) );
        privateAuctionEvent.eventType( eventType );

        return privateAuctionEvent.build();
    }

    protected ru.udisondev.globus.auction.event.LotInfo lotInfoToLotInfo(LotInfo lotInfo) {
        if ( lotInfo == null ) {
            return null;
        }

        ru.udisondev.globus.auction.event.LotInfo.LotInfoBuilder lotInfo1 = ru.udisondev.globus.auction.event.LotInfo.builder();

        lotInfo1.id( lotInfo.getId() );
        lotInfo1.state( lotInfo.getState() );
        lotInfo1.claimId( lotInfo.getClaimId() );
        lotInfo1.customerId( lotInfo.getCustomerId() );
        lotInfo1.deliveryFrom( lotInfo.getDeliveryFrom() );
        lotInfo1.deliveryTo( lotInfo.getDeliveryTo() );
        lotInfo1.deliveryAddress( lotInfo.getDeliveryAddress() );
        lotInfo1.arriveAddress( lotInfo.getArriveAddress() );
        lotInfo1.title( lotInfo.getTitle() );
        lotInfo1.weight( lotInfo.getWeight() );
        lotInfo1.placeForCargo( lotInfo.getPlaceForCargo() );
        lotInfo1.size( lotInfo.getSize() );
        lotInfo1.hazard( lotInfo.getHazard() );
        lotInfo1.temperatureFrom( lotInfo.getTemperatureFrom() );
        lotInfo1.temperatureTo( lotInfo.getTemperatureTo() );
        lotInfo1.vehicleType( lotInfo.getVehicleType() );
        lotInfo1.vehicleSubType( lotInfo.getVehicleSubType() );
        lotInfo1.deliveryPlacingType( lotInfo.getDeliveryPlacingType() );
        lotInfo1.arrivePlacingType( lotInfo.getArrivePlacingType() );
        lotInfo1.amount( lotInfo.getAmount() );
        lotInfo1.budget( lotInfo.getBudget() );
        lotInfo1.billingType( lotInfo.getBillingType() );

        return lotInfo1.build();
    }

    protected BidInfo bidEventToBidInfo(BidEvent bidEvent) {
        if ( bidEvent == null ) {
            return null;
        }

        BidInfo.BidInfoBuilder bidInfo = BidInfo.builder();

        bidInfo.id( bidEvent.getId() );
        bidInfo.producerId( bidEvent.getProducerId() );
        bidInfo.lotId( bidEvent.getLotId() );
        bidInfo.billingType( bidEvent.getBillingType() );
        bidInfo.bidPrice( bidEvent.getBidPrice() );

        return bidInfo.build();
    }
}
