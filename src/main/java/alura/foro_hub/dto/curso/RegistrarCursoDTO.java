package alura.foro_hub.dto.curso;

import jakarta.validation.constraints.NotBlank;

public record RegistrarCursoDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
