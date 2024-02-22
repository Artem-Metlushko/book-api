--liquibase formatted sql

--changeset metlushkoaa:1
CREATE TABLE IF NOT EXISTS "users"
(
    id       bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL


);

CREATE TABLE IF NOT EXISTS "roles"
(
    id   bigint PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles
(
    user_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles VALUES(1,'ROLE_ADMIN');




