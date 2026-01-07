CREATE TABLE mensagem_motivacional (
    id BIGINT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    ativo BOOLEAN NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    data_criacao TIMESTAMP NOT NULL
)
