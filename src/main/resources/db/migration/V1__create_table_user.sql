CREATE TABLE USER(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    coduser BIGINT NOT NULL,
    codobs BIGINT,
    name varchar(100),
    email varchar(100),
    dt_login DATE
)