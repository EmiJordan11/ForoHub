package alura.foro_hub.dto.topico;

import alura.foro_hub.entities.Topico;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long idAutor,
        Long idCurso
) {


    public TopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(),topico.getAutor().getId(),topico.getCurso().getId());
    }
}
