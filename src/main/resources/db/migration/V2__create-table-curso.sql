CREATE TABLE curso (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    categoria VARCHAR(60) NOT NULL,
    fecha_hora_baja TIMESTAMP
);
