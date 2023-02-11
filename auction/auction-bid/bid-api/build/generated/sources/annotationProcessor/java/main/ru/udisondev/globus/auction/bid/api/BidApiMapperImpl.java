package ru.udisondev.globus.auction.bid.api;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.service.model.BidInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-11T20:12:50+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class BidApiMapperImpl implements BidApiMapper {

    @Override
    public BidDto toResponse(BidInfo source) {
        if ( source == null ) {
            return null;
        }

        BidDto.BidDtoBuilder bidDto = BidDto.builder();

        bidDto.id( source.getId() );
        bidDto.producerId( source.getProducerId() );
        bidDto.lotId( source.getLotId() );
        bidDto.billingType( source.getBillingType() );
        bidDto.bidPrice( source.getBidPrice() );
        bidDto.state( source.getState() );

        return bidDto.build();
    }
}
