INSERT INTO author (id, name, birthdate, profilepicture_url)
VALUES (1, 'Samuel Scherrer', '23.07.2006', 'www.nevergonnagiveyouup.com'),
       (2, 'Aurora Gjm', '25.01.2007', 'www.aurora.com'),
       (3, 'Luis Kueng (Lueng)', '21.05.2006', 'lueng.ch'),
       (4, 'Blubben', '07.03.2007', 'blubben.nor'),
       (5, 'ahhh', 'bhhh', 'abc.abc');

INSERT INTO role (role_id, role_name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO authority (authority_id, authority_name)
VALUES (1, 'CREATE'),
       (2, 'READ'),
       (3, 'UPDATE'),
       (4, 'DELETE');

INSERT INTO role_authority (id_role, id_authority)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1);

INSERT INTO users (user_id, username, password, user_role)
VALUES (1, 'Banane', '1234', 1),
       (2, 'Samuel', '1234', 1),
       (3, 'Ruben', '1234', 2),
       (4, 'Aurora', '1234', 2);