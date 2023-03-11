package ru.udisondev.globus.telegram;

import org.springframework.context.ApplicationEventPublisher;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;

import java.util.List;

import static java.util.Optional.of;
import static ru.udisondev.globus.telegram.Command.CREATE_CLAIM;
import static ru.udisondev.globus.telegram.Command.defineCommand;

public class GlobusBot extends TelegramLongPollingBot {

    private final String token;
    private final CommandMapper mapper;
    private final ApplicationEventPublisher eventPublisher;


    public GlobusBot(String token, CommandMapper mapper, ApplicationEventPublisher eventPublisher) {
        this.token = token;
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
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
                .ifPresent(this::handleMessage);
    }

    @Override
    public String getBotUsername() {
        return "globusdelivery_bot";
    }

    private void handleMessage(Message m) {
        if (m.getText().startsWith("/")) {
            eventPublisher.publishEvent(mapper.map(m, defineCommand(m)));
        }
    }

        public SetMyCommands getCommands () {
            return new SetMyCommands(
                    List.of(
                            BotCommand.builder()
                                    .command(CREATE_CLAIM.getValue())
                                    .description(CREATE_CLAIM.getDescription())
                                    .build()),
                    BotCommandScopeDefault.builder().build(),
                    "ru");
        }
    }


