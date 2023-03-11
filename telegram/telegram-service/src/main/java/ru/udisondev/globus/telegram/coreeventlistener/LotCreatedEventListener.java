package ru.udisondev.globus.telegram.coreeventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
import ru.udisondev.globus.persistence.telegram.user.TelegramUserRepository;
import ru.udisondev.globus.telegram.GlobusProducerBot;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;

@Component
public class LotCreatedEventListener {

    private final GlobusProducerBot producerBot;
    private final TelegramUserRepository repository;

    public LotCreatedEventListener(GlobusProducerBot producerBot, TelegramUserRepository repository) {
        this.producerBot = producerBot;
        this.repository = repository;
    }

    @EventListener(condition = "#event.eventType.name() == 'LOT_OPENED'")
    public void handle(PrivateAuctionEvent event) {
        var hasBillingInfo = nonNull(event.getLotInfo().getBudget());
        var telegramUser = repository.findTelegramUserByUserId(event.getEventReceiver())
                .orElseThrow(() -> TelegramUserNotFoundException.byUserId(event.getEventReceiver()));
        // создаем кнопки для управления заявкой
        var lotId = event.getLotInfo().getId().toString();

        InlineKeyboardButton acceptOrderButton = new InlineKeyboardButton();
        acceptOrderButton.setText("Принять заявку");
        acceptOrderButton.setCallbackData("accept_claim" + lotId);

        InlineKeyboardButton suggestPriceButton = new InlineKeyboardButton();
        suggestPriceButton.setText("Предложить свою цену");
        suggestPriceButton.setCallbackData("suggest_price" + lotId);

        // создаем разметку клавиатуры
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        if (hasBillingInfo) {
            row1.add(acceptOrderButton);
        }
        row1.add(suggestPriceButton);
        keyboardMarkup.setKeyboard(Collections.singletonList(row1));

        var stringBuilder = new StringBuilder();

        stringBuilder.append("Новая заявка:\n");
        stringBuilder.append("Наименование: ").append(event.getLotInfo().getTitle())
                .append("\n");
        stringBuilder.append("Дата: ").append(event.getLotInfo().getDeliveryDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .append("\n");
        stringBuilder.append("Откуда: ").append(event.getLotInfo().getDeliveryAddress())
                .append("\n");
        stringBuilder.append("Куда: ").append(event.getLotInfo().getArriveAddress())
                .append("\n");
        stringBuilder.append("Тип транспорта: ")
                .append(event.getLotInfo().getVehicleType().getValue())
                .append("(")
                .append(event.getLotInfo().getVehicleSubType().getValue())
                .append(")")
                .append("\n");
        stringBuilder.append("Вес груза: ").append(event.getLotInfo().getWeight())
                .append(" кг")
                .append("\n");
        stringBuilder.append("Объем груза: ").append(event.getLotInfo().getSize())
                .append(" м³")
                .append("\n");
        if (hasBillingInfo) {
            stringBuilder.append("Форма оплаты: ")
                    .append(event.getLotInfo().getBudget())
                    .append(" руб/")
                    .append(event.getLotInfo().getBillingType())
                    .append("\n\n");
        }
        stringBuilder.append("Для выполнения заявки, нажмите кнопку \"Принять заявку\".\n" +
                "Если вы хотите предложить свою цену, нажмите кнопку \"Предложить свою цену\".");

        // создаем объект SendMessage для отправки сообщения
        SendMessage message = new SendMessage();
        message.setChatId(telegramUser.getChatId());
        message.setText(stringBuilder.toString());
        message.setReplyMarkup(keyboardMarkup);

        // отправляем сообщение
        try {
            producerBot.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
