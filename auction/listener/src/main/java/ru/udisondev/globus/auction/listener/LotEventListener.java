package ru.udisondev.globus.auction.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.auction.lot.event.LotEvent;
import ru.udisondev.globus.auction.publisher.AuctionEventPublisher;
import ru.udisondev.globus.producer.api.ProducerClient;

import static ru.udisondev.globus.persistence.enums.AuctionState.LOT_OPENED;

@Component
public class LotEventListener {

    private final ProducerClient producerClient;
    private final AuctionEventPublisher auctionEventPublisher;
    private final AuctionLotMapper mapper;

    public LotEventListener(ProducerClient producerClient, AuctionEventPublisher auctionEventPublisher, AuctionLotMapper mapper) {
        this.producerClient = producerClient;
        this.auctionEventPublisher = auctionEventPublisher;
        this.mapper = mapper;
    }

    @EventListener(condition = "#{event.state.name() == 'OPENED'}")
    public void opened(LotEvent event) {
        producerClient.findAll().stream()
                .map(producer -> PrivateAuctionEvent.builder()
                        .eventReceiver(producer.getUserId())
                        .lotInfo(mapper.map(event))
                        .eventType(LOT_OPENED)
                        .build())
                .forEach(auctionEventPublisher::publishPrivate);
    }

}
