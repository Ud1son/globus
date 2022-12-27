CREATE TABLE bid
(
    id                    UUID         NOT NULL,
    producer_id           UUID         NOT NULL,
    lot_id                UUID         NOT NULL,
    billing_type          VARCHAR(255) NOT NULL,
    bid_price             DECIMAL      NOT NULL,
    state                 INTEGER      NOT NULL,
    creation_date_time    TIMESTAMP WITHOUT TIME ZONE,
    last_update_date_time TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_bid PRIMARY KEY (id)
);

CREATE TABLE claim
(
    id                    BYTEA                       NOT NULL,
    customer_id           UUID                        NOT NULL,
    state                 INTEGER                     NOT NULL,
    creation_date_time    TIMESTAMP WITHOUT TIME ZONE,
    last_update_date_time TIMESTAMP WITHOUT TIME ZONE,
    delivery_from         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    delivery_to           TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    delivery_address      VARCHAR(255)                NOT NULL,
    arrive_address        VARCHAR(255)                NOT NULL,
    title                 VARCHAR(255)                NOT NULL,
    weight                INTEGER                     NOT NULL,
    place_for_cargo       SMALLINT                    NOT NULL,
    size                  SMALLINT                    NOT NULL,
    hazard                VARCHAR(255),
    temperature_from      SMALLINT,
    temperature_to        SMALLINT,
    vehicle_type          VARCHAR(255)                NOT NULL,
    vehicle_sub_type      VARCHAR(255)                NOT NULL,
    delivery_placing_type VARCHAR(255)                NOT NULL,
    arrive_placing_type   VARCHAR(255)                NOT NULL,
    amount                SMALLINT                    NOT NULL,
    budget                DECIMAL,
    billing_type          VARCHAR(255),
    CONSTRAINT pk_claim PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id                    UUID NOT NULL,
    user_id               UUID,
    organization_id       UUID,
    creation_date_time    TIMESTAMP WITHOUT TIME ZONE,
    last_update_date_time TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE globus_user
(
    id                     UUID         NOT NULL,
    state                  INTEGER      NOT NULL,
    registration_date_time TIMESTAMP WITHOUT TIME ZONE,
    last_update_date_time  TIMESTAMP WITHOUT TIME ZONE,
    first_name             VARCHAR(255) NOT NULL,
    last_name              VARCHAR(255) NOT NULL,
    middle_name            VARCHAR(255),
    phone                  VARCHAR(255) NOT NULL,
    email                  VARCHAR(255) NOT NULL,
    birth_day              date,
    is_paid                BOOLEAN,
    finish_date            date,
    plan                   INTEGER,
    CONSTRAINT pk_globus_user PRIMARY KEY (id)
);

CREATE TABLE lot
(
    id                    UUID                        NOT NULL,
    state                 VARCHAR(255),
    claim_id              VARCHAR(255)                NOT NULL,
    customer_id           UUID                        NOT NULL,
    confirmed_bid_id      UUID,
    delivery_from         TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    delivery_to           TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    delivery_address      VARCHAR(255)                NOT NULL,
    arrive_address        VARCHAR(255)                NOT NULL,
    title                 VARCHAR(255)                NOT NULL,
    weight                INTEGER                     NOT NULL,
    hazard                VARCHAR(255),
    place_for_cargo       SMALLINT                    NOT NULL,
    size                  SMALLINT                    NOT NULL,
    temperature_from      SMALLINT,
    temperature_to        SMALLINT,
    vehicle_type          VARCHAR(255)                NOT NULL,
    vehicle_sub_type      VARCHAR(255)                NOT NULL,
    delivery_placing_type VARCHAR(255)                NOT NULL,
    arrive_placing_type   VARCHAR(255)                NOT NULL,
    amount                SMALLINT                    NOT NULL,
    budget                DECIMAL,
    billing_type          VARCHAR(255),
    creation_date_time    TIMESTAMP WITHOUT TIME ZONE,
    last_update_date_time TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_lot PRIMARY KEY (id)
);

CREATE TABLE producer
(
    id                    UUID NOT NULL,
    user_id               UUID,
    organization_id       UUID,
    creation_date_time    TIMESTAMP WITHOUT TIME ZONE,
    last_update_date_time TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_producer PRIMARY KEY (id)
);

ALTER TABLE lot
    ADD CONSTRAINT uc_lot_claimid UNIQUE (claim_id);