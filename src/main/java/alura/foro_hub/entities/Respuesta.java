package alura.foro_hub.entities;

import alura.foro_hub.dto.respuesta.RegistrarRespuestaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "Respuesta")
public class Respuesta extends EntidadBase{
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    private Topico topico;
    @ManyToOne
    private Respuesta respuesta;
    @ManyToOne
    private Usuario autor;


    public Respuesta(RegistrarRespuestaDTO datos, Topico topico, Usuario autor) {
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.topico = topico;
        this.autor = autor;
    }

    public Respuesta(RegistrarRespuestaDTO datos, Usuario autor, Respuesta respuesta) {
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.topico = respuesta.getTopico(); //el mismo topico que la rta padre
        this.respuesta = respuesta;
        this.autor = autor;
    }

}
