package alura.foro_hub.dto.respuesta;

import alura.foro_hub.entities.Respuesta;

import java.time.LocalDateTime;

public record SubRespuestaDTO(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long idAutor,
        Long idTopico,
        Long idRespuesta
) {
    public SubRespuestaDTO(Respuesta subrespuesta) {
        this(subrespuesta.getId(), subrespuesta.getMensaje(), subrespuesta.getFechaCreacion(), subrespuesta.getAutor().getId(), subrespuesta.getTopico().getId(), subrespuesta.getRespuesta().getId());
    }
}
