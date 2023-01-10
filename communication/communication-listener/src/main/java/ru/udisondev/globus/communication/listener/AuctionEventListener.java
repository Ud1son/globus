package ru.udisondev.globus.communication.listener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.producer.api.ProducerClient;
import ru.udisondev.globus.user.api.UserClient;

@Component
public class AuctionEventListener {

    private final UserClient userClient;
    private final ProducerClient producerClient;

    public AuctionEventListener(UserClient userClient, @Qualifier("applicationProducerClient") ProducerClient producerClient) {
        this.userClient = userClient;
        this.producerClient = producerClient;
    }

    @EventListener(condition = "#event.eventType.name() == 'LOT_OPENED'")
    public void lotOpened(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        System.out.printf("""
                Dear, %s %s, we receive a new claim.
                
                Would you like to work with it?
                
                Claim:
                %s
                %n""",
                user.getFirstName(),
                user.getLastName(),
                event.getLotInfo());
    }


    @EventListener(condition = "#event.eventType.name() == 'BID_REQUESTED'")
    public void bidRequested(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        System.out.printf("""
               Dear, %s %s, we receive a bit for your claim.
               
               Would you like to approve it?
               Bid:
               %s
               
               Your claim:
               %s
               %n""",
                user.getFirstName(),
                user.getLastName(),
                event.getBidInfo(),
                event.getLotInfo());
    }

    @EventListener(condition = "#event.eventType.name() == 'BID_REJECTED'")
    public void bidRejected(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        System.out.printf("""
               Dear, %s %s, your bid is rejected.
               
               Your Bid:
               %s
               
               Claim:
               %s
               %n""",
                user.getFirstName(),
                user.getLastName(),
                event.getBidInfo(),
                event.getLotInfo());
    }

    @EventListener(condition = "#event.eventType.name() == 'BID_APPROVED'")
    public void bidApproved(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        System.out.printf("""
               Dear, %s %s, your bid is approved. Do you confirm?
               
               Your Bid:
               %s
               
               Claim:
               %s
               %n""",
                user.getFirstName(),
                user.getLastName(),
                event.getBidInfo(),
                event.getLotInfo());
    }

    @EventListener(condition = "#event.eventType.name() == 'BID_CONFIRMED'")
    public void bidConfirmed(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        var producerProfile = userClient.findById(producerClient.findById(event.getBidInfo().getProducerId()).getUserId()).getProfile();

        System.out.printf("""
               Dear, %s %s, ?
               
               Your claim was confirmed by:
               %s %s
               With bid:
               %s
               
               Your Claim:
               %s
               %n""",
                user.getFirstName(),
                user.getLastName(),
                producerProfile.getFirstName(),
                producerProfile.getLastName(),
                event.getBidInfo(),
                event.getLotInfo());
    }

    @EventListener(condition = "#event.eventType.name() == 'BID_CLOSED'")
    public void bidClosed(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        System.out.printf("""
               Dear, %s %s, your bid is closed.
               Your bid:
               %s
               Because claim was completed.
               Claim:
               %s
               %n""",
                user.getFirstName(),
                user.getLastName(),
                event.getBidInfo(),
                event.getLotInfo());
    }

    @EventListener(condition = "#event.eventType.name() == 'BID_CANCELLED'")
    public void bidCanceled(PrivateAuctionEvent event) {
        var user = userClient.findById(event.getEventReceiver()).getProfile();
        System.out.printf("""
               Dear, %s %s, bid is cancelled
               
               Bid:
               %s
               
               Your Claim:
               %s
               %n""",
                user.getFirstName(),
                user.getLastName(),
                event.getBidInfo(),
                event.getLotInfo());
    }

}
