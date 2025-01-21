package alura.foro_hub.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Respuesta extends EntidadBase{
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private Topico topico;
    @ManyToOne
    private Respuesta respuestaPadre;
    @ManyToOne
    private Usuario autor;
}
