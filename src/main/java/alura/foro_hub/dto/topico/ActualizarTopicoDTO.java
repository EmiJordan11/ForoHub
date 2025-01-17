package alura.foro_hub.dto.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopicoDTO(
        @NotNull
        Long id,
        String titulo,
        String mensaje
) {
}
