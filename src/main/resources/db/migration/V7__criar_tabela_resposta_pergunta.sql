CREATE TABLE resposta_pergunta (
    id BIGINT PRIMARY KEY,
    tentativa_quiz_id BIGINT NOT NULL,
    pergunta_id BIGINT NOT NULL,
    opcao_resposta_id BIGINT, -- NULL = pulou
    tempo_gasto_segundos INT NOT NULL,
    correta BOOLEAN,
    data_resposta TIMESTAMP,

    CONSTRAINT fk_resposta_tentativa
       FOREIGN KEY (tentativa_quiz_id) REFERENCES tentativa_quiz(id),

    CONSTRAINT fk_resposta_pergunta
       FOREIGN KEY (pergunta_id) REFERENCES pergunta(id),

    CONSTRAINT fk_resposta_opcao
       FOREIGN KEY (opcao_resposta_id) REFERENCES opcao_resposta(id),

    CONSTRAINT uq_resposta_unica
       UNIQUE (tentativa_quiz_id, pergunta_id)
)
