package ru.udisondev.globus.telegram;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCommand {

    private final Command type;
    private final String text;
    private final Long chatId;
}
