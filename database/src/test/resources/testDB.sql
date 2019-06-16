INSERT INTO bookshop_storage.user (id, login, password, name, surname, rights, mail, address, tel)
VALUES (98, 'admin', 'password', 'узер', 'узерович', 'FULL', 'user@mail.com', 'Glebki street', '+375(25)906-47-10'),
       (99, 'user', 'password', 'узер', 'узерович', 'FULL', 'user@mail.com', 'Glebki street', '+375(25)906-47-10');

INSERT INTO bookshop_storage.book (id, name, about, img_link, genre, price, pages, type)
VALUES (97, 'ХИМИЯ', 'О химии', 'img', 'COMEDY', 100, 300, 'PRINTEDBOOK'),
       (98, 'ФИЗИКА', 'О физике', 'img', 'CLASSIC', 100, 300, 'PRINTEDBOOK'),
       (99, 'БИОЛОГИЯ', 'О биологии', 'img', 'CLASSIC', 100, 300, 'PRINTEDBOOK');

INSERT INTO bookshop_storage.author (id, name, surname, bio)
VALUES (98, 'Maksim', 'Galkin', 'Molodec'),
       (99, 'Vitaly', 'Zenkov', 'Molodec');

INSERT INTO bookshop_storage.blacklist (user_id, reason)
VALUES (99, 'rugalsia matom');

INSERT INTO bookshop_storage.comment (id, user_id, book_id, text)
VALUES (98, 99, 97, 'ne lublu himiu('),
       (99, 99, 99, 'i etu toje');

INSERT INTO bookshop_storage.booking (id, user_id, is_completed, is_processed)
VALUES (97, 99, TRUE, TRUE),
       (98, 99, TRUE, FALSE),
       (99, 99, FALSE, FALSE);

INSERT INTO bookshop_storage.booking_book (booking_id, book_id)
VALUES (98, 97),
       (98, 98),
       (98, 99),
       (99, 97);

INSERT INTO bookshop_storage.book_author (book_id, author_id)
VALUES (97, 98),
       (98, 98),
       (98, 99),
       (99, 99);