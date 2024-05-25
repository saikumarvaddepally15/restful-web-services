

INSERT INTO user_details (id, birth_date, username) VALUES (1001, CURRENT_DATE(), 'sai');
INSERT INTO user_details (id, birth_date, username) VALUES (1002, CURRENT_DATE(), 'saikumar');
INSERT INTO user_details (id, birth_date, username) VALUES (1003, CURRENT_DATE(), 'nanisai');


INSERT INTO post (id, description, user_id) VALUES (2001,'Im watching movie', 1001);
INSERT INTO post (id, description, user_id) VALUES (2002,'Im dancing ina concert', 1001);
INSERT INTO post (id, description, user_id) VALUES (2003,'Im watching movie with a friend', 1002);