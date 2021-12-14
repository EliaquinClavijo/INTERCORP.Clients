CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS client;

CREATE TABLE IF NOT EXISTS client (
    id uuid default uuid_generate_v4(),
    name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    age integer NOT NULL,
    birthdate timestamp without time zone NOT NULL
        DEFAULT (current_timestamp AT TIME ZONE 'UTC')
);

INSERT INTO client
(id, "name", last_name, age, birthdate)
VALUES(uuid_generate_v4(), 'ELIAQUIN', 'CLAVIJO MANUTTUPA', 24, '1997-01-04 00:00:00');
INSERT INTO client
(id, "name", last_name, age, birthdate)
VALUES(uuid_generate_v4(), 'ESTEFANI FIORELA', 'TINAJEROS MARTINEZ', 26, '1995-02-28 00:00:00');
