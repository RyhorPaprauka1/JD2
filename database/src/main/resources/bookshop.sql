CREATE DATABASE bookshop_repository;

CREATE SCHEMA bookshop_storage;

CREATE TABLE "user"
(
    id       BIGSERIAL PRIMARY KEY,
    login    VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(50)  NOT NULL,
    name     VARCHAR(50)  NOT NULL,
    surname  VARCHAR(50)  NOT NULL,
    rights   VARCHAR(32)  NOT NULL,
    mail     VARCHAR(124) NOT NULL,
    address  VARCHAR(124) NOT NULL,
    tel      CHAR(17)     NOT NULL
);

CREATE TABLE book
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(124) NOT NULL,
    about        text,
    img_link     VARCHAR(256),
    genre        VARCHAR(64)  NOT NULL,
    price        INTEGER      NOT NULL,
    type         VARCHAR(50)  NOT NULL,
    e_format     VARCHAR(4),
    audio_format VARCHAR(3),
    pages        INTEGER
);

CREATE TABLE author
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    bio     text
);

CREATE TABLE "booking"
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT  NOT NULL REFERENCES "user" (id),
    is_completed BOOLEAN NOT NULL,
    is_processed BOOLEAN NOT NULL
);

CREATE TABLE comment
(
    id      BIGSERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES "user" (id),
    book_id INTEGER NOT NULL REFERENCES book (id),
    text    text    NOT NULL
);

CREATE TABLE blacklist
(
    user_id BIGINT      NOT NULL UNIQUE REFERENCES "user" (id),
    reason  VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE booking_book
(
    booking_id BIGINT NOT NULL REFERENCES "booking" (id),
    book_id    BIGINT NOT NULL REFERENCES book (id),
    PRIMARY KEY (booking_id, book_id)
);

CREATE TABLE book_author
(
    book_id   BIGINT NOT NULL REFERENCES book (id),
    author_id BIGINT NOT NULL REFERENCES author (id),
    PRIMARY KEY (author_id, book_id)
);

