package ru.udisondev.globus.telegram;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.telegram.telegrambots.meta.api.objects.Message;

@Mapper(componentModel = "spring", imports = {Message.class})
public interface CommandMapper {

    @Mappings({
            @Mapping(target = "type", source = "command"),
            @Mapping(target = "text", source = "m.text"),
            @Mapping(target = "chatId", source = "m.chat.id"),
            @Mapping(target = "telegramUserId", source = "m.from.id")
    })
    UserCommand map(Message m, Command command);
}
