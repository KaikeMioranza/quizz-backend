CREATE TABLE quiz (
    id BIGINT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    categoria VARCHAR(100),
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP,
    minimo_acertos INT NOT NULL,
    valor_credito INT NOT NULL,
    permitir_rejogo BOOLEAN NOT NULL
);
