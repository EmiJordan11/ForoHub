package alura.foro_hub.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record LoginUsuarioDTO(
        @NotBlank
        String email,
        @NotBlank
        String contrasena
) {
}
