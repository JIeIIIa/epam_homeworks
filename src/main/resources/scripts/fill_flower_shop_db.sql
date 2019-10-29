INSERT INTO accessories(accessory_name, price)
VALUES ('butterfly', 42),
       ('strip', 100),
       ('box', 230);

INSERT INTO flowers(flower_type, flower_length, freshnesslevel, price, lily_size, chamomile_petals, rose_thorns)
VALUES ('ROSE', 42, 100, 55, NULL, NULL, 33),
       ('ROSE', 10, 33, 25, NULL, NULL, 15),
       ('ROSE', 50, 100, 123, NULL, NULL, 33),
       ('LILY', 22, 100, 40, 15, NULL, NULL),
       ('LILY', 5, 33, 25, 10, NULL, NULL),
       ('LILY', 30, 100, 23, 17, NULL, NULL),
       ('CHAMOMILE', 32, 100, 45, NULL, 37, NULL),
       ('CHAMOMILE', 4, 33, 75, NULL, 12, NULL),
       ('CHAMOMILE', 27, 100, 223, NULL, 31, NULL);

INSERT INTO bouquets(name)
VALUES ('THE_FIRST');

INSERT INTO bouquets_flowers(id_bouquet, id_flower)
VALUES (1, 3),
       (1, 6),
       (1, 9);

INSERT INTO bouquets_accessories(id_bouquet, id_accessory)
VALUES (1, 1),
       (1, 3);
