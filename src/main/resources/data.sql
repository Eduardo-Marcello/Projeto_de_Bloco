INSERT INTO SITUACAO(status) VALUES ('Escala em producao');
INSERT INTO SITUACAO(status) VALUES('Normal');
INSERT INTO SITUACAO(status) VALUES('Cancelado');
INSERT INTO SITUACAO(status) VALUES('Adiado');

INSERT INTO EMPRESA(nome, pais) Values ('Azul', 'Brasil');
INSERT INTO EMPRESA(nome, pais) Values ('GO', 'Brasil');
INSERT INTO EMPRESA(nome, pais) Values ('LATAM', 'Brasil');
INSERT INTO EMPRESA(nome, pais) Values ('American Airlines', 'Estados Unidos');
INSERT INTO EMPRESA(nome, pais) Values ('Aerolineas Argentinas', 'Argentina');
INSERT INTO EMPRESA(nome, pais) Values ('Tap Portugal', 'Portugal');

INSERT INTO VOO(codigo, destino, data_hora_partida, data_hora_chegada, status_id, empresa_id)
VALUES ('3458', 'Amapa', '2024-06-20 12:30:00', '2024-06-20 5:30:00', 2, 1);

INSERT INTO VOO(codigo, destino, data_hora_partida, data_hora_chegada, status_id, empresa_id)
VALUES ('3459', 'Minas Gerais', '2024-06-22 12:30:00', '2024-06-22 2:15:00', 4, 3);

INSERT INTO VOO(codigo, destino, data_hora_partida, data_hora_chegada, status_id, empresa_id)
VALUES ('4567', 'Portugal', '2024-06-20 09:30:00', '2024-06-20 21:50:00', 2, 6);

INSERT INTO VOO(codigo, destino, status_id, empresa_id)
VALUES ('4568', 'Estados Unidos', 1, 4);

INSERT INTO ROLE(nome) VALUES ('ADMIN');
INSERT INTO ROLE(nome) VALUES ('USER');
INSERT INTO ROLE(nome) VALUES ('SUP');

INSERT INTO USUARIO(nome,email,status,password) VALUES ('Donald', 'adminstrador@disney.com', 1, 'pato');
INSERT INTO USUARIO(nome,email,status,password) VALUES ('Mickey', 'user@disney.com', 1, 'rato');
INSERT INTO USUARIO(nome,email,status,password) VALUES ('Pateta', 'suporte@disney.com', 1, 'cachorro');
INSERT INTO USUARIO(nome,email,status,password) VALUES ('Bafo de Onça', 'exfuncionario@acme.com', 0, 'senha');

INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (1,1);
INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (2,2);
INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (3,3);
INSERT INTO USUARIO_ROLES(ROLES_ID, USUARIO_ID) VALUES (2,4);