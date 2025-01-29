package alura.foro_hub.dto.respuesta;

import alura.foro_hub.entities.Respuesta;

import java.time.LocalDateTime;

public record RespuestaDTO(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long idAutor,
        Long idTopico
) {
    public RespuestaDTO(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(),respuesta.getAutor().getId(),respuesta.getTopico().getId());
    }


}

