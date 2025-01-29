package alura.foro_hub.dto.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarRespuestaDTO(
        @NotBlank
        String mensaje
) {
}
