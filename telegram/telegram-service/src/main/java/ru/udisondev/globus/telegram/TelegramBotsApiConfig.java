package ru.udisondev.globus.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramBotsApiConfig {

    @Bean
    GlobusBot globusBot(@Value("${app.telegram.token}") String token) {
        return new GlobusBot(token);
    }

    @Bean
    TelegramBotsApi telegramBotsApi(GlobusBot globusBot) throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(globusBot);

        return telegramBotsApi;
    }
}
