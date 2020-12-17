INSERT INTO tegs (name, status)
VALUES ('#Срочные новости', 1),
       ('#covid-19', 1),
       ('#сгу', 1),
       ('#Saratov', 1);

INSERT INTO news (name, description, status)
VALUES ('Пожар', 'Сгорел старинный особняк', 1),
       ('Цены снова растут!', 'А вы что хотели?!!?!', 1),
       ('Начало сессии', 'Внимание! С 1 декабря начинается сессия.', 1),
       ('Скоро умрет 20000000 человек!!!!', 'По подсчетом ученных .....', 1);


INSERT INTO news_tegs_set (news_id, tegs_set_id)
VALUES (1, 1),
       (1, 4),
       (2, 1),
       (3, 3),
       (4, 1),
       (4, 2);

INSERT INTO comment (text, create_at, update_at, status)
VALUES ('Ужас!',now(), now(), 1),
         ('Как будто чт-то новое',now(), now(), 1),
         ('МЫ ВСЕ УМРЕМ!!!!',now(), now(), 1);

INSERT INTO news_comments(news_id, comments_id)
VALUES (1, 1),
       (4,2),
       (4,3);