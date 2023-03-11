package ru.udisondev.globus.persistence.telegram.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class TelegramUser {

    @Id
    private Long telegramUserId;

    @Column(nullable = false, unique = true)
    private Long chatId;

    @Column(nullable = false,
            unique = true,
            updatable = false)
    private UUID userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TelegramUser that = (TelegramUser) o;
        return telegramUserId != null && Objects.equals(telegramUserId, that.telegramUserId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
