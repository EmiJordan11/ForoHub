package alura.foro_hub.controller;

import alura.foro_hub.dto.respuesta.ActualizarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RegistrarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RespuestaDTO;
import alura.foro_hub.dto.respuesta.SubRespuestaDTO;
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
@RequestMapping("")
//@RequestMapping("/topicos/{idTopico}/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    //    -- RESPUESTA --
    @PostMapping("/topicos/{idTopico}/respuestas")
    public ResponseEntity registrarRespuesta(@PathVariable Long idTopico, @RequestBody @Valid RegistrarRespuestaDTO datos, UriComponentsBuilder uriComponentsBuilder){
        RespuestaDTO datosResponse = service.registrarRespuesta(idTopico, datos);
        URI url = uriComponentsBuilder.path("/topicos/{idTopico}/respuestas/{id}")
                .buildAndExpand(idTopico,datosResponse.id()).toUri();
        return ResponseEntity.created(url).body(datosResponse);
    }

    @GetMapping("/topicos/{idTopico}/respuestas")
    public ResponseEntity obtenerRespuestas(@PathVariable Long idTopico){
        List<RespuestaDTO> datosResponse = service.obtenerRespuestas(idTopico);
        return ResponseEntity.ok(datosResponse);
    }

    @PutMapping("respuestas/{idRespuesta}")
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid ActualizarRespuestaDTO datos, @PathVariable Long idRespuesta){
        RespuestaDTO datosResponse = service.actualizarRespuesta(datos, idRespuesta);

        return ResponseEntity.ok(datosResponse);
    }

    @DeleteMapping("respuestas/{idRespuesta}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long idRespuesta){
        service.eliminarRespuesta(idRespuesta);
        return ResponseEntity.noContent().build();
    }

//    -- SUBRESPUESTA --
    @PostMapping("respuestas/{idRespuesta}/subrespuestas")
    public ResponseEntity registrarSubRespuesta(@RequestBody @Valid RegistrarRespuestaDTO datos, @PathVariable Long idRespuesta){
        SubRespuestaDTO datosResponse = service.registrarSubRespuesta(datos, idRespuesta);
        return ResponseEntity.ok(datosResponse);
    }

    @GetMapping("/respuestas/{idRespuesta}/subrespuestas")
    public ResponseEntity obtenerSubRespuestas(@PathVariable Long idRespuesta){
        List<SubRespuestaDTO> datosResponse = service.obtenerSubRespuestas(idRespuesta);
        return ResponseEntity.ok(datosResponse);
    }

    @PutMapping("subrespuestas/{idSubRespuesta}")
    @Transactional
    public ResponseEntity actualizarSubRespuesta(@RequestBody @Valid ActualizarRespuestaDTO datos,@PathVariable Long idSubRespuesta){
        SubRespuestaDTO datosResponse = service.actualizarSubRespuesta(datos, idSubRespuesta);
        return ResponseEntity.ok(datosResponse);
    }

    @DeleteMapping("subrespuestas/{idSubRespuesta}")
    @Transactional
    public ResponseEntity eliminarSubRespuesta(@PathVariable Long idSubRespuesta){
        service.eliminarRespuesta(idSubRespuesta);
        return ResponseEntity.noContent().build();
    }

}
