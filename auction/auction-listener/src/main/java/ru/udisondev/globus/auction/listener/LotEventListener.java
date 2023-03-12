package ru.udisondev.globus.auction.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.auction.lot.event.LotEvent;
import ru.udisondev.globus.auction.publisher.AuctionEventPublisher;
import ru.udisondev.globus.user.api.UserClient;

import static ru.udisondev.globus.persistence.enums.AuctionState.LOT_OPENED;

@Component("auctionLotEventListener")
public class LotEventListener {

    private final UserClient userClient;
    private final AuctionEventPublisher auctionEventPublisher;
    private final AuctionLotMapper mapper;

    public LotEventListener(UserClient userClient, AuctionEventPublisher auctionEventPublisher, AuctionLotMapper mapper) {
        this.userClient = userClient;
        this.auctionEventPublisher = auctionEventPublisher;
        this.mapper = mapper;
    }

    @EventListener(condition = "#event.state.name() == 'OPENED'")
    public void opened(LotEvent event) {
        userClient.findAllProducers().stream()
                .map(producer -> PrivateAuctionEvent.builder()
                        .eventReceiver(producer.getId())
                        .lotInfo(mapper.map(event))
                        .eventType(LOT_OPENED)
                        .build())
                .forEach(auctionEventPublisher::publishPrivate);
    }

}
