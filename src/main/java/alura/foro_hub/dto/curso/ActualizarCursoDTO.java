package alura.foro_hub.dto.curso;

import jakarta.validation.constraints.NotNull;

public record ActualizarCursoDTO(
        @NotNull
        Long id,
        String nombre,
        String categoria
) {
}
