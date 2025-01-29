package alura.foro_hub.controller;

import alura.foro_hub.dto.respuesta.ActualizarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RegistrarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RespuestaDTO;
import alura.foro_hub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos/{idTopico}/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @PostMapping
    public ResponseEntity registrarRespuesta(@PathVariable Long idTopico, @RequestBody @Valid RegistrarRespuestaDTO datos, UriComponentsBuilder uriComponentsBuilder){
        RespuestaDTO datosResponse = service.registrarRespuesta(idTopico, datos);
        URI url = uriComponentsBuilder.path("/topicos/{idTopico}/respuestas/{id}")
                .buildAndExpand(idTopico,datosResponse.id()).toUri();
        return ResponseEntity.created(url).body(datosResponse);
    }

    @GetMapping
    public ResponseEntity obtenerRespuestas(@PathVariable Long idTopico){
        List<RespuestaDTO> datosResponse = service.obtenerRespuestas(idTopico);
        return ResponseEntity.ok(datosResponse);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarRespuesta(@PathVariable Long idTopico, @PathVariable Long id,
                                              @RequestBody @Valid ActualizarRespuestaDTO datos){
        RespuestaDTO datosResponse = service.actualizarRespuesta(idTopico, id, datos);

        return ResponseEntity.ok(datosResponse);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long idTopico, @PathVariable Long id){
        service.eliminarRespuesta(idTopico, id);
        return ResponseEntity.noContent().build();
    }


}
