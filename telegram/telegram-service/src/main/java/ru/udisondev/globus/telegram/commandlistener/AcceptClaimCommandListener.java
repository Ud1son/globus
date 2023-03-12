package ru.udisondev.globus.telegram.commandlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.udisondev.globus.auction.bid.api.BidClient;
import ru.udisondev.globus.auction.bid.api.CreateBidRequest;
import ru.udisondev.globus.auction.lot.api.LotClient;
import ru.udisondev.globus.persistence.telegram.user.TelegramUserRepository;
import ru.udisondev.globus.telegram.UserCommand;

import java.util.UUID;

@Component
public class AcceptClaimCommandListener {

    private final BidClient bidClient;
    private final LotClient lotClient;

    private final TelegramUserRepository telegramUserRepository;

    public AcceptClaimCommandListener(BidClient bidClient, LotClient lotClient, TelegramUserRepository telegramUserRepository) {
        this.bidClient = bidClient;
        this.lotClient = lotClient;
        this.telegramUserRepository = telegramUserRepository;
    }

    @EventListener(condition = "#command.type == 'ACCEPT_CLAIM'")
    public void handle(UserCommand command) {
        var claimNumber = UUID.fromString(command.getText().split(" ")[1]);
        var lot = lotClient.findById(claimNumber);

        bidClient.create(CreateBidRequest.builder()
                        .lotId(lot.getId())
                        .bidPrice(lot.getBudget())
                        .billingType(lot.getBillingType())
                        .producerId(telegramUserRepository.findById(command.getTelegramUserId())
                                .orElseThrow()
                                .getUserId())
                .build());
    }

}
