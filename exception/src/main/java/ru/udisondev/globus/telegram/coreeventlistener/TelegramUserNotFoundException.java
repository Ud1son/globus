package ru.udisondev.globus.telegram.coreeventlistener;

import java.util.UUID;

public class TelegramUserNotFoundException extends RuntimeException {

    private TelegramUserNotFoundException(String message) {
        super(message);
    }

    public static TelegramUserNotFoundException byUserId(UUID eventReceiver) {
        return new TelegramUserNotFoundException("Telegram user not found for user with ID: %s".formatted(eventReceiver));
    }
}
