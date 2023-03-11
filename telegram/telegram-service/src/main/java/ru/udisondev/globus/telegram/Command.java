package ru.udisondev.globus.telegram;

import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Message;

@Getter
public enum Command {

    ACCEPT_CLAIM("accept_claim", "Принять заявку"),

    CREATE_CLAIM("create_claim", "Создать заявку");

    private final String value;
    private final String description;


    Command(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Command defineCommand(Message m) {
        var command = m.getText().split(" ")[0];
        switch (command) {
            case "/create_claim":
                return CREATE_CLAIM;
            default: return null;
        }
    }
}
