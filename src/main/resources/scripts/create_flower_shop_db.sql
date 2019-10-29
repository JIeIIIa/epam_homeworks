DROP DATABASE IF EXISTS flower_shop;

CREATE DATABASE flower_shop;

DROP TABLE IF EXISTS bouquets_accessories;
DROP TABLE IF EXISTS bouquets_flowers;
DROP TABLE IF EXISTS bouquets;
DROP TABLE IF EXISTS flowers;
DROP TABLE IF EXISTS accessories;

DROP SEQUENCE IF EXISTS bouquets_id_seq;
DROP SEQUENCE IF EXISTS accessories_id_seq;
DROP SEQUENCE IF EXISTS flowers_id_seq;

DROP TYPE IF EXISTS flower_type_enum;
CREATE TYPE flower_type_enum AS ENUM ('LILY', 'CHAMOMILE', 'ROSE');

CREATE SEQUENCE flowers_id_seq;
CREATE TABLE IF NOT EXISTS flowers
(
    id               int         NOT NULL DEFAULT nextval('flowers_id_seq'),
    flower_type      flower_type_enum,
    flower_length    int         NOT NULL DEFAULT 0,
    freshnessLevel   int         NOT NULL DEFAULT 0,
    price            int         NOT NULL DEFAULT 0,

    lily_size        int,
    chamomile_petals int,
    rose_thorns      int,

    CONSTRAINT flowers_pk PRIMARY KEY (id)
);
ALTER SEQUENCE flowers_id_seq
    OWNED BY flowers.id;


CREATE SEQUENCE accessories_id_seq;
CREATE TABLE IF NOT EXISTS accessories
(
    id             int         NOT NULL DEFAULT nextval('accessories_id_seq'),
    accessory_name VARCHAR(50) NOT NULL,
    price          int         NOT NULL DEFAULT 0,

    CONSTRAINT accessories_pk PRIMARY KEY (id)
);
ALTER SEQUENCE accessories_id_seq
    OWNED BY accessories.id;



CREATE SEQUENCE bouquets_id_seq;
CREATE TABLE IF NOT EXISTS bouquets
(
    id   int         NOT NULL DEFAULT nextval('bouquets_id_seq'),
    name VARCHAR(40) NOT NULL,

    CONSTRAINT bouquets_pk PRIMARY KEY (id)
);
ALTER SEQUENCE bouquets_id_seq
    OWNED BY bouquets.id;


CREATE TABLE IF NOT EXISTS bouquets_accessories
(
    id_bouquet   int NOT NULL,
    id_accessory int NOT NULL,

    CONSTRAINT bouquets_accessories_pk PRIMARY KEY (id_bouquet, id_accessory),
    CONSTRAINT fk_bouquets
        FOREIGN KEY (id_bouquet)
            REFERENCES bouquets (id),
    CONSTRAINT fk_accessories
        FOREIGN KEY (id_accessory)
            REFERENCES accessories (id)
);



CREATE TABLE IF NOT EXISTS bouquets_flowers
(
    id_bouquet int NOT NULL,
    id_flower  int NOT NULL,

    CONSTRAINT bouquets_flowers_pk PRIMARY KEY (id_bouquet, id_flower),
    CONSTRAINT fk_bouquets
        FOREIGN KEY (id_bouquet)
            REFERENCES bouquets (id),
    CONSTRAINT fk_flowers
        FOREIGN KEY (id_flower)
            REFERENCES flowers (id)
);

