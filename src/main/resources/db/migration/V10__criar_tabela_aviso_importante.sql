CREATE TABLE aviso_importante (
    id BIGINT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    severidade VARCHAR(20) NOT NULL, -- INFO | ALERTA | CRITICO
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP,
    ativo BOOLEAN ,
    data_criacao TIMESTAMP NOT NULL
)