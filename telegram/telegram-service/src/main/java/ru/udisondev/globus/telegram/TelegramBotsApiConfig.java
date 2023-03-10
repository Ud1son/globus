package ru.udisondev.globus.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Configuration
public class TelegramBotsApiConfig {

    @Bean
    GlobusBot globusBot(@Value("${app.telegram.customer.token}") String token, CommandMapper mapper, ApplicationEventPublisher eventPublisher) {
        return new GlobusBot(token, mapper, eventPublisher);
    }

    @Bean
    GlobusProducerBot globusProducerBot(@Value("${app.telegram.producer.token}") String token, CommandMapper mapper, ApplicationEventPublisher eventPublisher) {
        return new GlobusProducerBot(token, mapper, eventPublisher);
    }

    @Bean(name = "customerBot")
    TelegramBotsApi globusCustomerBot(GlobusBot globusBot) throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        ofNullable(globusBot.getCommands()).ifPresent(c -> addCommands(globusBot, c));
        telegramBotsApi.registerBot(globusBot);

        return telegramBotsApi;
    }
//
//    @Bean(name = "producerBot")
//    TelegramBotsApi globusProducerBot(GlobusProducerBot globusBot) throws TelegramApiException {
//        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//        ofNullable(globusBot.getCommands()).ifPresent(c -> addCommands(globusBot, c));
//        telegramBotsApi.registerBot(globusBot);
//
//        return telegramBotsApi;
//    }

    private static void addCommands(TelegramLongPollingBot bot, SetMyCommands c) {
        try {
            bot.execute(c);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
