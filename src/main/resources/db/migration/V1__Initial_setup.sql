CREATE SEQUENCE configuracoes_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE ponto_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE configuracoes (
    id INTEGER NOT NULL PRIMARY KEY,
    ativa BOOLEAN NOT NULL,
    jornada_diaria_horas REAL NOT NULL,
    qtd_hora_extra_permitida REAL NOT NULL,
    timestamp TIMESTAMP(6)
);

CREATE TABLE usuario (
    id INTEGER NOT NULL PRIMARY KEY,
    papel SMALLINT CHECK (papel BETWEEN 0 AND 1),
    email VARCHAR(255),
    name VARCHAR(255)
);

CREATE TABLE ponto (
    id INTEGER NOT NULL PRIMARY KEY,
    tipo_ponto SMALLINT CHECK (tipo_ponto BETWEEN 0 AND 1),
    timestamp TIMESTAMP(6),
    config_id INTEGER,
    usuario_id INTEGER
);

-- Adição das foreign keys
ALTER TABLE IF EXISTS ponto
    ADD CONSTRAINT FKdw4fveyrgjmlcv2s9qavdfci0 FOREIGN KEY (config_id) REFERENCES configuracoes;

ALTER TABLE IF EXISTS ponto
    ADD CONSTRAINT FK4a2xo7agbjdr58v1o7jh0uf1y FOREIGN KEY (usuario_id) REFERENCES usuario;