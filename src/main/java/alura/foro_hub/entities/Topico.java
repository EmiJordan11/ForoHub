package alura.foro_hub.entities;

import alura.foro_hub.dto.topico.RegistrarTopicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
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
public class Topico extends EntidadBase {
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;

    public Topico(RegistrarTopicoDTO datos, Usuario autor, Curso curso) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = autor;
        this.curso = curso;
    }

//    public Topico(RegistrarTopicoDTO datos) {
//        this.titulo = datos.titulo();
//        this.mensaje = datos.mensaje();
//        this.fechaCreacion = datos.fechaCreacion();
//        this.autor = datos.
//    }
}
