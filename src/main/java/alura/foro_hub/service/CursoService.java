package alura.foro_hub.service;

import alura.foro_hub.dto.curso.ActualizarCursoDTO;
import alura.foro_hub.dto.curso.CursoDTO;
import alura.foro_hub.dto.curso.RegistrarCursoDTO;
import alura.foro_hub.entities.Curso;
import alura.foro_hub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    //POST
    public CursoDTO registrarCurso(RegistrarCursoDTO datos){
        Curso curso = new Curso(datos);
        curso = repository.save(curso);

        //retorno el DTO
        return new CursoDTO(curso);
    }

    //GET
    public List<CursoDTO> listarCursos(){
        List<Curso> cursos = repository.findAll();
        return cursos.stream().map(CursoDTO::new).toList();
    }

    //PUT
    public CursoDTO actualizarCurso(ActualizarCursoDTO datos){
        Curso curso = repository.getReferenceById(datos.id());
        if (datos.nombre()!=null && !datos.nombre().isBlank()){
            curso.setNombre(datos.nombre());
        }
        if (datos.categoria()!=null && !datos.categoria().isBlank()){
            curso.setCategoria(datos.categoria());
        }

        return new CursoDTO(curso);
    }

    //DELETE
    public void eliminarCurso(Long id){
        Curso curso = repository.getReferenceById(id);
        //setteo la fecha de baja con fecha actual
        curso.setFechaHoraBaja(LocalDateTime.now());
    }


}
