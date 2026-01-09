CREATE TABLE pergunta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quiz_id BIGINT NOT NULL,
    enunciado TEXT NOT NULL,
    tempo_limite_segundos INT NOT NULL,
    ordem INT NOT NULL,

    CONSTRAINT fk_pergunta_quiz
      FOREIGN KEY (quiz_id) REFERENCES quiz(id),

    CONSTRAINT uq_ordem_pergunta
      UNIQUE (quiz_id, ordem)
)
