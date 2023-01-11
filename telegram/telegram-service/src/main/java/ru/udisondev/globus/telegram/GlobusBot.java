package ru.udisondev.globus.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

public class GlobusBot extends TelegramLongPollingBot {

    private final String token;

    public GlobusBot(String token) {
        this.token = token;
    }

    @Override
    public String getBotToken() {
        return token;
    }


    /*
    if (update.hasMessage() && update.getMessage().hasText()) {
        // Set variables
        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();

        SendMessage message = new SendMessage() // Create a message object object
                .setChatId(chat_id)
                .setText(message_text);
        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
     */
    @Override
    public void onUpdateReceived(Update update) {
        Optional.of(update)
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


