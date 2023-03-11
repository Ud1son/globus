package ru.udisondev.globus.telegram.commandlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.udisondev.globus.telegram.GlobusBot;
import ru.udisondev.globus.telegram.UserCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CreateClaimCommandListener {

    private final GlobusBot globusBot;

    public CreateClaimCommandListener(GlobusBot globusBot) {
        this.globusBot = globusBot;
    }

    @EventListener(condition = "#c.type.name() == 'CREATE_CLAIM'")
    public void handle(UserCommand c) throws TelegramApiException {
        // создаем кнопку для создания заявки
        InlineKeyboardButton createOrderButton = new InlineKeyboardButton();
        createOrderButton.setText("Создать заявку");
        createOrderButton.setUrl("http://127.0.0.1:3000");

        // создаем разметку клавиатуры
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(createOrderButton);
        keyboardMarkup.setKeyboard(Collections.singletonList(row));

        // создаем объект SendMessage для отправки сообщения с кнопкой
        SendMessage message = new SendMessage(c.getChatId().toString(), "Привет! Я чат-бот, который поможет вам найти лучшее предложение для грузоперевозки.\n" +
                "Для создания новой заявки, нажмите кнопку \"Создать заявку\" ниже.");
        message.setReplyMarkup(keyboardMarkup);

        // отправляем сообщение
        globusBot.execute(message);

    }
}
