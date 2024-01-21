--liquibase formatted sql

--changeset metlushkoaa:1
CREATE TABLE IF NOT EXISTS "books"
(

    id     bigint PRIMARY KEY ,
    name   VARCHAR(255) NOT NULL,
    author    VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NOT NULL
);

--changeset metlushkoaa:2

INSERT INTO "books" (id, name, author, description)
VALUES (11, 'name11', 'author11', 'description11' );

INSERT INTO "books" (id, name, author, description)
VALUES (12, 'name12', 'author12', 'description12' );

INSERT INTO "books" (id, name, author, description)
VALUES (13, 'name13', 'author13', 'description13' );

INSERT INTO "books" (id, name, author, description)
VALUES (14, 'name14', 'author14', 'description14' );


