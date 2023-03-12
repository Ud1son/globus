package ru.udisondev.globus.telegram.coreeventlistener;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.udisondev.globus.common.util.FunctionUtil;
import ru.udisondev.globus.persistence.telegram.user.TelegramUser;
import ru.udisondev.globus.persistence.telegram.user.TelegramUserRepository;
import ru.udisondev.globus.telegram.GlobusProducerBot;

import java.util.*;
import java.util.function.Consumer;

import static ru.udisondev.globus.common.util.FunctionUtil.combine;

public abstract class CoreEventListener {

    protected final GlobusProducerBot producerBot;
    protected final TelegramUserRepository repository;

    public CoreEventListener(GlobusProducerBot producerBot, TelegramUserRepository repository) {
        this.producerBot = producerBot;
        this.repository = repository;
    }

    public TelegramUser findTelegramUserByUserId(UUID userId) {
        return repository.findTelegramUserByUserId(userId)
                .orElseThrow(() -> TelegramUserNotFoundException.byUserId(userId));
    }

    @SafeVarargs
    public static InlineKeyboardMarkup addButtons(List<InlineKeyboardButton>... buttons) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(Arrays.asList(buttons));
        return keyboardMarkup;
    }

    @SafeVarargs
    public static InlineKeyboardButton createButton(Consumer<InlineKeyboardButton> first, Consumer<InlineKeyboardButton>... operations) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        combine(first, operations).accept(button);
        return button;
    }
}
