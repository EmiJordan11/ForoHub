package alura.foro_hub.service;

import alura.foro_hub.dto.respuesta.ActualizarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RegistrarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RespuestaDTO;
import alura.foro_hub.dto.respuesta.SubRespuestaDTO;
import alura.foro_hub.entities.Respuesta;
import alura.foro_hub.entities.Topico;
import alura.foro_hub.entities.Usuario;
import alura.foro_hub.infra.errors.ValidacionException;
import alura.foro_hub.repository.RespuestaRepository;
import alura.foro_hub.repository.TopicoRepository;
import alura.foro_hub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoService topicoService;

    // --------------------------------------------------------------------------------------------------------------
    //    -- RESPUESTA --

    //POST
    public RespuestaDTO registrarRespuesta(Long topicoId, RegistrarRespuestaDTO datos) {
        Topico topico = topicoService.validarTopico(topicoId);
        Usuario autor =  usuarioRepository.getReferenceById(datos.idAutor());
        Respuesta respuesta = new Respuesta(datos, topico, autor);
        respuesta = respuestaRepository.save(respuesta);

        return new RespuestaDTO(respuesta);
    }

    //GET
    public List<RespuestaDTO> obtenerRespuestas(Long idTopico) {
        Topico topico = topicoService.validarTopico(idTopico);
        List<Respuesta> respuestas = respuestaRepository.findByTopicoIdAndFechaHoraBajaIsNull(idTopico);

        return respuestas.stream().map(RespuestaDTO::new).toList();
    }

    //PUT
    public RespuestaDTO actualizarRespuesta(ActualizarRespuestaDTO datos, Long id) {
        Respuesta respuesta = validarRespuesta(id);

        respuesta.setMensaje(datos.mensaje());

        return new RespuestaDTO(respuesta);
    }

    //DELETE
    public void eliminarRespuesta(Long id) {
        Respuesta respuesta = validarRespuesta(id);
        respuesta.setFechaHoraBaja(LocalDateTime.now());
    }

    // --------------------------------------------------------------------------------------------------------------
    //    -- SUBRESPUESTA --
    //POST
    public SubRespuestaDTO registrarSubRespuesta(RegistrarRespuestaDTO datos, Long idRespuesta) {
        Respuesta respuesta = validarRespuesta(idRespuesta);
        Usuario autor = usuarioRepository.getReferenceById(datos.idAutor());

        //creo la subrespuesta
        Respuesta subrespuesta = new Respuesta(datos, autor, respuesta);
        respuestaRepository.save(subrespuesta);

        return new SubRespuestaDTO(subrespuesta);
    }

    //GET
    public List<SubRespuestaDTO> obtenerSubRespuestas(Long idRespuesta) {
        Respuesta respuestaPadre = validarRespuesta(idRespuesta);
        List<Respuesta> subrespuestas = respuestaRepository.findByRespuestaIdAndFechaHoraBajaIsNull(respuestaPadre.getId());

        return subrespuestas.stream().map(SubRespuestaDTO::new).toList();
    }

    //PUT
    public SubRespuestaDTO actualizarSubRespuesta(ActualizarRespuestaDTO datos ,Long idSubRespuesta) {
        Respuesta subrespuesta = validarRespuesta(idSubRespuesta);
        subrespuesta.setMensaje(datos.mensaje());

        return new SubRespuestaDTO(subrespuesta);
    }



    //Validar
    public Respuesta validarRespuesta(Long idRespuesta) {
        Respuesta respuesta = respuestaRepository.getReferenceById(idRespuesta);
        if (respuesta.getFechaHoraBaja()!=null){
            throw new ValidacionException("La respuesta seleccionada ya no existe");
        }

        return respuesta;
    }


}
