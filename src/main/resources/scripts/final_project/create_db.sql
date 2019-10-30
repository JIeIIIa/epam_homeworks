DROP DATABASE IF EXISTS restaurant;

CREATE DATABASE restaurant;

DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS bills;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS products_id_seq;
DROP SEQUENCE IF EXISTS ingredients_id_seq;
DROP SEQUENCE IF EXISTS users_id_seq;
DROP SEQUENCE IF EXISTS dishes_id_seq;
DROP SEQUENCE IF EXISTS bills_id_seq;
DROP SEQUENCE IF EXISTS orders_id_seq;

DROP TYPE IF EXISTS user_role_enum;
CREATE TYPE user_role_enum AS ENUM ('CLIENT', 'ADMIN', 'CHIEF');

DROP TYPE IF EXISTS dish_status_enum;
CREATE TYPE dish_status_enum AS ENUM ('TODO', 'IN_PROGRESS', 'DONE');


CREATE SEQUENCE products_id_seq;
CREATE TABLE IF NOT EXISTS products
(
    id    int         NOT NULL DEFAULT nextval('products_id_seq'),
    title VARCHAR(60) NOT NULL,

    CONSTRAINT products_pk PRIMARY KEY (id)
);
ALTER SEQUENCE products_id_seq
    OWNED BY products.id;

CREATE SEQUENCE dishes_id_seq;
CREATE TABLE IF NOT EXISTS dishes
(
    id        int         NOT NULL DEFAULT nextval('dishes_id_seq'),
    title     VARCHAR(60) NOT NULL,
    price     int         NOT NULL,
    is_active bool        NOT NULL,

    CONSTRAINT dishes_pk PRIMARY KEY (id)
);
ALTER SEQUENCE dishes_id_seq
    OWNED BY dishes.id;


CREATE SEQUENCE ingredients_id_seq;
CREATE TABLE IF NOT EXISTS ingredients
(
    id         int NOT NULL DEFAULT nextval('ingredients_id_seq'),
    id_product int NOT NULL,
    id_dish    int NOT NULL,
    weight     int NOT NULL,

    CONSTRAINT ingredients_pk PRIMARY KEY (id),
    CONSTRAINT fk_ingredient_product
        FOREIGN KEY (id_product)
            REFERENCES products (id),
    CONSTRAINT fk_ingredient_dish
        FOREIGN KEY (id_dish)
            REFERENCES dishes (id)
);
ALTER SEQUENCE ingredients_id_seq
    OWNED BY ingredients.id;


CREATE SEQUENCE users_id_seq;
CREATE TABLE IF NOT EXISTS users
(
    id            int            NOT NULL DEFAULT nextval('users_id_seq'),
    user_login    VARCHAR(40)    NOT NULL,
    user_password VARCHAR(50)    NOT NULL,
    salt          VARCHAR(20)    NOT NULL,
    role          user_role_enum NOT NULL,

    CONSTRAINT users_pk PRIMARY KEY (id)
);
ALTER SEQUENCE users_id_seq
    OWNED BY users.id;



CREATE SEQUENCE bills_id_seq;
CREATE TABLE IF NOT EXISTS bills
(
    id        int NOT NULL DEFAULT nextval('bills_id_seq'),
    id_user   int NOT NULL,
    paid_sum  int,
    bill_date TIMESTAMP,

    CONSTRAINT bills_pk PRIMARY KEY (id),
    CONSTRAINT fk_bills_users
        FOREIGN KEY (id_user)
            REFERENCES users (id)
);
ALTER SEQUENCE bills_id_seq
    OWNED BY bills.id;


CREATE SEQUENCE orders_id_seq;
CREATE TABLE IF NOT EXISTS orders
(
    id          int              NOT NULL DEFAULT nextval('orders_id_seq'),
    id_dish     int              NOT NULL,
    id_user     int,
    dish_status dish_status_enum NOT NULL,

    CONSTRAINT orders_pk PRIMARY KEY (id),
    CONSTRAINT fk_orders_dish
        FOREIGN KEY (id_dish)
            REFERENCES dishes (id),
    CONSTRAINT fk_orders_users
        FOREIGN KEY (id_user)
            REFERENCES users (id)

);
ALTER SEQUENCE orders_id_seq
    OWNED BY orders.id;