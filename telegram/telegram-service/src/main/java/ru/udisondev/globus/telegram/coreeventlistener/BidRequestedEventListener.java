package ru.udisondev.globus.telegram.coreeventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.persistence.telegram.user.TelegramUserRepository;
import ru.udisondev.globus.telegram.GlobusProducerBot;
import ru.udisondev.globus.user.api.UserClient;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class BidRequestedEventListener extends CoreEventListener {

    private final UserClient userClient;

    public BidRequestedEventListener(GlobusProducerBot producerBot, TelegramUserRepository repository, UserClient userClient) {
        super(producerBot, repository);
        this.userClient = userClient;
    }

    @EventListener(condition = "#event.eventType.name() == 'BID_REQUESTED'")
    public void handle(PrivateAuctionEvent event) {
        var telegramUser = findTelegramUserByUserId(event.getEventReceiver());
        // создаем кнопки для управления заявкой
        var bidId = event.getBidInfo().getId();
        var producerId = event.getBidInfo().getProducerId();
        var producer = userClient.findById(producerId);

        var text = """
                На вашу заявку #%d "%s"
                Созданную %s
                поступило предложение от от перевозчика:
                "%s"
                ИНН: %s
                """.formatted(
                event.getLotInfo().getLotOrder(),
                event.getLotInfo().getTitle(),
                event.getLotInfo().getCreationDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                producer.getOrganization().getOrganizationName(),
                producer.getOrganization().getInn());

        if (event.getBidInfo().getBidPrice().compareTo(event.getLotInfo().getBudget()) != 0 ||
                event.getBidInfo().getBillingType() != event.getLotInfo().getBillingType()) {
            text += """
                    Условия грузоперевозчика: %s руб/%s
                    """.formatted(event.getBidInfo().getBidPrice(), event.getBidInfo().getBillingType());
        } else {
            text += """
                    Перевозчик готов выполнить заказ на ваших условиях:
                    %s руб/%s
                    """.formatted(event.getLotInfo().getBudget(), event.getLotInfo().getBillingType());
        }
        SendMessage message = new SendMessage();
        message.setChatId(telegramUser.getChatId());
        message.setText(text);

        // создаем объект SendMessage для отправки сообщения
        message.setReplyMarkup(
                addButtons(
                        List.of(createButton(
                                        b -> b.setText("Выбрать грузоперевозчика"),
                                        b -> b.setCallbackData("approve_bid " + bidId)),
                                createButton(
                                        b -> b.setText("Отклонить предложение"),
                                        b -> b.setCallbackData("reject_bid" + bidId)
                                )
                        )
                )
        );

        try {
            producerBot.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
