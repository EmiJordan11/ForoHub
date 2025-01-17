package alura.foro_hub.dto.curso;


import alura.foro_hub.entities.Curso;

public record CursoDTO(
        Long id,
        String nombre,
        String categoria
) {


    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
