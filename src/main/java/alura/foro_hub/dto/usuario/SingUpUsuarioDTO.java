package alura.foro_hub.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SingUpUsuarioDTO(
        @NotBlank
        String nombre,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String contrasena
) {
}
