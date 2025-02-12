package alura.foro_hub.entities;

import alura.foro_hub.dto.curso.ActualizarCursoDTO;
import alura.foro_hub.dto.curso.RegistrarCursoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Curso")
public class Curso extends EntidadBase{
    private String nombre;
    private String categoria;

    public Curso(RegistrarCursoDTO datos) {
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
    }

}
