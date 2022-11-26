--liquibase formatted sql

--changeset davis:0
create sequence hibernate_sequence start 1 increment 1;

create table wish
(
    id          int8         not null,
    created_at  timestamp    not null,
    modified_at timestamp    not null,
    text        varchar(255) not null,
    primary key (id)
);