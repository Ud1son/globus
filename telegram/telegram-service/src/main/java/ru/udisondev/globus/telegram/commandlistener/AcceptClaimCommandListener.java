//package ru.udisondev.globus.telegram.commandlistener;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import ru.udisondev.globus.auction.bid.api.BidClient;
//import ru.udisondev.globus.auction.bid.api.CreateBidRequest;
//import ru.udisondev.globus.telegram.UserCommand;
//
//import java.util.UUID;
//
//@Component
//public class AcceptClaimCommandListener {
//
//    private final BidClient bidClient;
//    private final LotClient lotClient;
//
//    public AcceptClaimCommandListener(BidClient bidClient) {
//        this.bidClient = bidClient;
//    }
//
//    @EventListener(condition = "#command.type == 'ACCEPT_CLAIM'")
//    public void handle(UserCommand command) {
//        var claimNumber = UUID.fromString(command.getText().split(" ")[1]);
//        bidClient.create(CreateBidRequest);
//    }
//
//}
