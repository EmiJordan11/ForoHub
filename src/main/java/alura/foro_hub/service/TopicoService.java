package alura.foro_hub.service;

import alura.foro_hub.dto.topico.ActualizarTopicoDTO;
import alura.foro_hub.dto.topico.RegistrarTopicoDTO;
import alura.foro_hub.dto.topico.TopicoDTO;
import alura.foro_hub.entities.Curso;
import alura.foro_hub.entities.Respuesta;
import alura.foro_hub.entities.Topico;
import alura.foro_hub.entities.Usuario;
import alura.foro_hub.infra.errors.ValidacionException;
import alura.foro_hub.repository.CursoRepository;
import alura.foro_hub.repository.RespuestaRepository;
import alura.foro_hub.repository.TopicoRepository;
import alura.foro_hub.repository.UsuarioRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    //POST
    public TopicoDTO registrarTopico(RegistrarTopicoDTO datos){
        Usuario usuario = usuarioRepository.getReferenceById(datos.idAutor());
        Curso curso = cursoRepository.getReferenceById(datos.idCurso());

        Topico topico = new Topico(datos, usuario, curso);
        topico = topicoRepository.save(topico);

        //retorno el DTO
       return new TopicoDTO(topico);
    }

    //GET
    public List<TopicoDTO> listarTopicos(){
        List<Topico> topicos = topicoRepository.findByFechaHoraBajaIsNull();
        return topicos.stream().map(TopicoDTO::new).toList();
    }

    //PUT
    public TopicoDTO actualizarTopico(ActualizarTopicoDTO datos){
        Topico topico = validarTopico(datos.id());

        if (datos.titulo()!=null && !datos.titulo().isBlank()){
            topico.setTitulo(datos.titulo());
        }
        if (datos.mensaje()!=null && !datos.mensaje().isBlank()){
            topico.setMensaje(datos.mensaje());
        }

        return new TopicoDTO(topico);
    }

    //DELETE
    public void eliminarTopico(Long id) {
        Topico topico = validarTopico(id);
        //setteo la fecha de baja con fecha actual
        topico.setFechaHoraBaja(LocalDateTime.now());

        //setteo la fecha de baja a cada respuesta de este tópico
        List<Respuesta> respuestas = respuestaRepository.findByTopicoIdAndFechaHoraBajaIsNull(id);
        for (Respuesta respuesta : respuestas){
            respuesta.setFechaHoraBaja(LocalDateTime.now());
        }
    }

    //Validar Topico
    public Topico validarTopico(Long id){
        Topico topico = topicoRepository.getReferenceById(id);

        if (topico.getFechaHoraBaja()!=null){
            throw new ValidacionException("El tópico seleccionado ya no existe");
        }

        return topico;
    }

}
