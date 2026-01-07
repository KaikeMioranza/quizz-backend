CREATE TABLE tentativa_quiz (
    id BIGINT PRIMARY KEY,
    quiz_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP,
    status VARCHAR(20) NOT NULL, -- EM_ANDAMENTO | FINALIZADO | EXPIRADO
    total_acertos INT,
    total_erros INT,
    total_pulos INT,
    aprovado BOOLEAN,
    credito_gerado BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_tentativa_quiz
        FOREIGN KEY (quiz_id) REFERENCES quiz(id),

    CONSTRAINT fk_tentativa_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)
