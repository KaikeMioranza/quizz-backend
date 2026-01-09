CREATE TABLE opcao_resposta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pergunta_id BIGINT NOT NULL,
    descricao TEXT NOT NULL,
    correta BOOLEAN NOT NULL,
    ordem INT NOT NULL,

    CONSTRAINT fk_opcao_pergunta
        FOREIGN KEY (pergunta_id) REFERENCES pergunta(id),

    CONSTRAINT uq_ordem_opcao
        UNIQUE (pergunta_id, ordem)
)
