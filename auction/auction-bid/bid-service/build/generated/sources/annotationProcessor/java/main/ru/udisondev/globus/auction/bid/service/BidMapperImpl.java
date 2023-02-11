package ru.udisondev.globus.auction.bid.service;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.event.BidEvent;
import ru.udisondev.globus.auction.bid.service.model.BidDataProvider;
import ru.udisondev.globus.auction.bid.service.model.BidInfo;
import ru.udisondev.globus.persistence.bid.Bid;
import ru.udisondev.globus.persistence.enums.BidState;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T20:12:49+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class BidMapperImpl implements BidMapper {

    @Override
    public Bid toEntry(BidDataProvider bidDataProvider) {
        if ( bidDataProvider == null ) {
            return null;
        }

        Bid bid = new Bid();

        bid.setProducerId( bidDataProvider.getProducerId() );
        bid.setLotId( bidDataProvider.getLotId() );
        bid.setBillingType( bidDataProvider.getBillingType() );
        bid.setBidPrice( bidDataProvider.getBidPrice() );

        bid.setState( BidState.REQUESTED );

        return bid;
    }

    @Override
    public BidEvent toEvent(Bid bid) {
        if ( bid == null ) {
            return null;
        }

        BidEvent.BidEventBuilder bidEvent = BidEvent.builder();

        bidEvent.id( bid.getId() );
        bidEvent.producerId( bid.getProducerId() );
        bidEvent.lotId( bid.getLotId() );
        bidEvent.billingType( bid.getBillingType() );
        bidEvent.bidPrice( bid.getBidPrice() );
        bidEvent.state( bid.getState() );

        return bidEvent.build();
    }

    @Override
    public BidInfo toDto(Bid bid) {
        if ( bid == null ) {
            return null;
        }

        BidInfo.BidInfoBuilder bidInfo = BidInfo.builder();

        bidInfo.id( bid.getId() );
        bidInfo.producerId( bid.getProducerId() );
        bidInfo.lotId( bid.getLotId() );
        bidInfo.billingType( bid.getBillingType() );
        bidInfo.bidPrice( bid.getBidPrice() );
        bidInfo.state( bid.getState() );

        return bidInfo.build();
    }
}
