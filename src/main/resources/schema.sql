CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS client;

CREATE TABLE IF NOT EXISTS client (
    id uuid default uuid_generate_v4(),
    name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    age integer NOT NULL,
    birthdate date);

INSERT INTO client
(id, "name", last_name, age, birthdate)
VALUES(uuid_generate_v4(), 'ELIAQUIN', 'CLAVIJO MANUTTUPA', 24, '1997-01-04');
INSERT INTO client
(id, "name", last_name, age, birthdate)
VALUES(uuid_generate_v4(), 'ESTEFANI FIORELA', 'TINAJEROS MARTINEZ', 26, '1995-02-28');
INSERT INTO client
(id, "name", last_name, age, birthdate)
VALUES(uuid_generate_v4(), 'JOAQUIN', 'CLAVIJO MANUTTUPA', 21, '2001-07-06');
