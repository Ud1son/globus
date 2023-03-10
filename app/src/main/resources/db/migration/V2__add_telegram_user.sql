CREATE TABLE telegram_user
(
    telegram_user_id BIGINT NOT NULL,
    chat_id          BIGINT NOT NULL,
    user_id          UUID   NOT NULL,
    CONSTRAINT pk_telegramuser PRIMARY KEY (telegram_user_id)
);

ALTER TABLE telegram_user
    ADD CONSTRAINT uc_telegramuser_chatid UNIQUE (chat_id);

ALTER TABLE telegram_user
    ADD CONSTRAINT uc_telegramuser_userid UNIQUE (user_id);