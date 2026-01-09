CREATE TABLE transacao_credito (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    tentativa_quiz_id BIGINT,
    valor INT NOT NULL,
    tipo VARCHAR(20) NOT NULL, -- GANHO | AJUSTE | ESTORNO
    data_criacao TIMESTAMP NOT NULL,

    CONSTRAINT fk_credito_usuario
       FOREIGN KEY (usuario_id) REFERENCES usuarios(id),

    CONSTRAINT fk_credito_tentativa
       FOREIGN KEY (tentativa_quiz_id) REFERENCES tentativa_quiz(id)
)
