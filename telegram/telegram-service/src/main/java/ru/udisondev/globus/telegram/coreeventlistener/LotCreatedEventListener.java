//package ru.udisondev.globus.telegram.coreeventlistener;
//
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import ru.udisondev.globus.auction.event.PrivateAuctionEvent;
//import ru.udisondev.globus.telegram.GlobusProducerBot;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Component
//public class LotCreatedEventListener {
//
//    private final GlobusProducerBot producerBot;
//
//    public LotCreatedEventListener(GlobusProducerBot producerBot) {
//        this.producerBot = producerBot;
//    }
//
//    @EventListener(condition = "#event.eventType.name() == 'LOT_OPENED'")
//    public void handle(PrivateAuctionEvent event) {
//        // создаем кнопки для управления заявкой
//        var lotId = event.getLotInfo().getId().toString();
//
//        InlineKeyboardButton acceptOrderButton = new InlineKeyboardButton();
//        acceptOrderButton.setText("Принять заявку");
//        acceptOrderButton.setCallbackData("accept_claim" + lotId);
//
//        InlineKeyboardButton suggestPriceButton = new InlineKeyboardButton();
//        suggestPriceButton.setText("Предложить свою цену");
//        suggestPriceButton.setCallbackData("suggest_price" + lotId);
//
//        // создаем разметку клавиатуры
//        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
//        List<InlineKeyboardButton> row1 = new ArrayList<>();
//        row1.add(acceptOrderButton);
//        row1.add(suggestPriceButton);
//        keyboardMarkup.setKeyboard(Collections.singletonList(row1));
//
//        // создаем текст сообщения с информацией о заявке
//        String messageText = "Новая заявка:\n" +
//                "Груз: " + cargoDescription + "\n" +
//                "Откуда: " + from + "\n" +
//                "Куда: " + to + "\n" +
//                "Тип транспорта: " + transportType + "\n" +
//                "Требования к перевозке: " + requirements + "\n\n" +
//                "Для выполнения заявки, нажмите кнопку \"Принять заявку\".\n" +
//                "Если вы хотите предложить свою цену, нажмите кнопку \"Предложить свою цену\".";
//
//        // создаем объект SendMessage для отправки сообщения
//        SendMessage message = new SendMessage()
//                .setChatId(chatId)
//                .setText(messageText)
//                .setReplyMarkup(keyboardMarkup);
//
//        // отправляем сообщение
//        execute(message);
//
//    }
//}
