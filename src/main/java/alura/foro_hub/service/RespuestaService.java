package alura.foro_hub.service;

import alura.foro_hub.dto.respuesta.ActualizarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RegistrarRespuestaDTO;
import alura.foro_hub.dto.respuesta.RespuestaDTO;
import alura.foro_hub.entities.Respuesta;
import alura.foro_hub.entities.Topico;
import alura.foro_hub.entities.Usuario;
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

    public RespuestaDTO registrarRespuesta(Long topicoId, RegistrarRespuestaDTO datos) {
        Topico topico = topicoRepository.getReferenceById(topicoId);
        Usuario autor =  usuarioRepository.getReferenceById(datos.idAutor());
        Respuesta respuesta = new Respuesta(datos, topico, autor);
        respuesta = respuestaRepository.save(respuesta);

        return new RespuestaDTO(respuesta);
    }

    public List<RespuestaDTO> obtenerRespuestas(Long idTopico) {
        Topico topico = validarTopico(idTopico);
        List<Respuesta> respuestas = respuestaRepository.findByTopicoId(idTopico);

        return respuestas.stream().map(RespuestaDTO::new).toList();
    }

    public RespuestaDTO actualizarRespuesta(Long idTopico, Long id, @Valid ActualizarRespuestaDTO datos) {
        Topico topico = validarTopico(idTopico);
        Respuesta respuesta = respuestaRepository.getReferenceById(id);

        respuesta.setMensaje(datos.mensaje());

        return new RespuestaDTO(respuesta);
    }


    public void eliminarRespuesta(Long idTopico, Long id) {
//        Topico topico = validarTopico(idTopico);
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.setFechaHoraBaja(LocalDateTime.now());
    }

    public Topico validarTopico(Long idTopico) {
        //largar exception si no existe!!!!!
        return topicoRepository.getReferenceById(idTopico);
    }


}
