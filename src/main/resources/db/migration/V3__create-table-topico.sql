CREATE TABLE topico (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL UNIQUE,
    mensaje VARCHAR(800) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    fecha_hora_baja TIMESTAMP,

    FOREIGN KEY(autor_id) REFERENCES usuario(id),
    FOREIGN KEY(curso_id) REFERENCES curso(id)
);
