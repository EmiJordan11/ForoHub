CREATE TABLE topico(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titulo VARCHAR(200) NOT NULL UNIQUE,
    mensaje VARCHAR(800) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    fecha_hora_baja DATETIME,

    FOREIGN KEY(autor_id) REFERENCES Usuario(id),
    FOREIGN KEY(curso_id) REFERENCES Curso(id)
);