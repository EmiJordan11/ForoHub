package alura.foro_hub.controller;

import alura.foro_hub.dto.topico.ActualizarTopicoDTO;
import alura.foro_hub.dto.topico.RegistrarTopicoDTO;
import alura.foro_hub.dto.topico.TopicoDTO;
import alura.foro_hub.dto.usuario.RegistrarUsuarioDTO;
import alura.foro_hub.entities.Topico;
import alura.foro_hub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;


    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid RegistrarTopicoDTO datos, UriComponentsBuilder uriComponentsBuilder){
        TopicoDTO datosResponse = service.registrarTopico(datos);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosResponse.id()).toUri();
        return ResponseEntity.created(url).body(datosResponse);
    }

    @GetMapping
    public ResponseEntity obtenerTopicos(){
        List<TopicoDTO> datosResponse = service.listarTopicos();
        return ResponseEntity.ok(datosResponse);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid ActualizarTopicoDTO datos){
        TopicoDTO datosResponse = service.actualizarTopico(datos);
        return ResponseEntity.ok(datosResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        service.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
