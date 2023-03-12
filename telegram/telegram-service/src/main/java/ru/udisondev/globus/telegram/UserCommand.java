package ru.udisondev.globus.telegram;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserCommand {

    private final Command type;
    private final String text;
    private final Long chatId;

    private final Long telegramUserId;
}
