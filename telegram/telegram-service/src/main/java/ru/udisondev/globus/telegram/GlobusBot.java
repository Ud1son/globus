package ru.udisondev.globus.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static java.util.Optional.of;

public class GlobusBot extends TelegramLongPollingBot {

    private final String token;

    public GlobusBot(String token) {
        this.token = token;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        of(update)
                .filter(Update::hasMessage)
                .map(Update::getMessage)
                .filter(Message::hasText)
                .ifPresent(this::sendMessage);
    }

    @Override
    public String getBotUsername() {
        return "globusdelivery_bot";
    }

    private void sendMessage(Message m) {
        try {
            var message = new SendMessage();
            message.setChatId(m.getChatId());
            message.setText(m.getText());
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}


