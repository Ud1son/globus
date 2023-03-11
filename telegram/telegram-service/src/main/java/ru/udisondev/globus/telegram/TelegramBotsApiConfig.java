package ru.udisondev.globus.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

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

    @Bean(name = "producerBot")
    TelegramBotsApi globusProducerBotApi(GlobusProducerBot globusProducerBot) throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        ofNullable(globusProducerBot.getCommands()).ifPresent(c -> addCommands(globusProducerBot, c));
        telegramBotsApi.registerBot(globusProducerBot);

        return telegramBotsApi;
    }

    private static void addCommands(TelegramLongPollingBot bot, SetMyCommands c) {
        try {
            bot.execute(c);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
