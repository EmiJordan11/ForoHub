package alura.foro_hub.controller;

import alura.foro_hub.dto.curso.ActualizarCursoDTO;
import alura.foro_hub.dto.curso.CursoDTO;
import alura.foro_hub.dto.curso.RegistrarCursoDTO;
import alura.foro_hub.entities.Curso;
import alura.foro_hub.repository.CursoRepository;
import alura.foro_hub.service.CursoService;
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
    private CursoService service;

    @PostMapping
    public ResponseEntity registrarCurso(@RequestBody @Valid RegistrarCursoDTO datos, UriComponentsBuilder uriComponentsBuilder){
        CursoDTO datosResponse = service.registrarCurso(datos);
        //creo la uri
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(datosResponse.id()).toUri();
        return ResponseEntity.created(url).body(datosResponse);
    }

    @GetMapping
    public ResponseEntity obtenerCursos(){
        List<CursoDTO> datosResponse = service.listarCursos();
        return ResponseEntity.ok(datosResponse);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid ActualizarCursoDTO datos){
        CursoDTO datosResponse = service.actualizarCurso(datos);

        return ResponseEntity.ok(datosResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        service.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }



}
