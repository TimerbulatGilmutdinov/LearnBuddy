create table users
(
    id            bigserial primary key,
    name          varchar(60) not null,
    surname       varchar(60) not null,
    email         varchar(60) not null unique,
    password_hash varchar(32) not null,
    birthdate     varchar not null,
    gender        varchar(6)  not null,
    country       varchar(60) not null references countries(name),
    city          varchar(60) not null,
    is_admin      bool default false
);

create table admins
(
    id            bigserial primary key,
    email         varchar(60) references users (email) not null
);

create table subjects
(
    id   bigserial primary key,
    name varchar not null unique
);

create table user_subject
(
    user_id    bigserial,
    maths bool default false,
    physics bool default false,
    english_language bool default false,
    programming bool default false,
    history bool default false,
    economics bool default false,
    law bool default false,
    foreign key (user_id) references users (id)
);

create table countries(
    id bigserial primary key ,
    name varchar unique
);

drop table users;
drop table admins;
drop table subjects;
drop table user_subject;
drop table countries;


