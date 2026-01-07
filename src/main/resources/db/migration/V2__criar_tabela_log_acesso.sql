CREATE TABLE log_acesso_usuario (
    id BIGINT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    data_login TIMESTAMP NOT NULL,
    ip VARCHAR(50),
    dispositivo VARCHAR(100),

    CONSTRAINT fk_log_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)
