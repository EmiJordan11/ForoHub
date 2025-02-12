CREATE TABLE curso(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    categoria VARCHAR(60) NOT NULL,
    fecha_hora_baja DATETIME
);