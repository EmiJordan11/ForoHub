CREATE TABLE Respuesta(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    mensaje VARCHAR(800) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    respuesta_id BIGINT,
    fecha_hora_baja DATETIME,

    FOREIGN KEY(topico_id) REFERENCES Topico(id),
    FOREIGN KEY(autor_id) REFERENCES Usuario(id),
    FOREIGN KEY(respuesta_id) REFERENCES Respuesta(id)
);