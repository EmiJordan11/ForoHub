CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(60) NOT NULL UNIQUE,
    contrasena VARCHAR(100) NOT NULL,
    fecha_hora_baja TIMESTAMP
);
