package alura.foro_hub.controller;

import alura.foro_hub.dto.curso.ActualizarCursoDTO;
import alura.foro_hub.dto.curso.CursoDTO;
import alura.foro_hub.dto.curso.RegistrarCursoDTO;
import alura.foro_hub.entities.Curso;
import alura.foro_hub.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public ResponseEntity registrarCurso(@RequestBody @Valid RegistrarCursoDTO datos, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = new Curso(datos);
        curso = repository.save(curso);
        //lo transformo a DTO
        CursoDTO datosResponse = new CursoDTO(curso);
        //creo la uri
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(url).body(datosResponse);
    }

    @GetMapping
    public ResponseEntity obtenerCursos(){
        List<Curso> cursos = repository.findAll();
        return ResponseEntity.ok(cursos.stream().map(CursoDTO::new).toList());
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid ActualizarCursoDTO datos){
        Curso curso = repository.getReferenceById(datos.id());

        curso.actualizarDatos(datos);
        CursoDTO datosResponse = new CursoDTO(curso);

        return ResponseEntity.ok(datosResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        Curso curso = repository.getReferenceById(id);
        curso.eliminarCurso();
        return ResponseEntity.noContent().build();

    }



}
