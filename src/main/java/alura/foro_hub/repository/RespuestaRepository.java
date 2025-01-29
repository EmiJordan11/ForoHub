package alura.foro_hub.repository;

import alura.foro_hub.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByTopicoIdAndFechaHoraBajaIsNull(Long idTopico);
}
