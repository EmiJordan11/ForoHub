package alura.foro_hub.repository;

import alura.foro_hub.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByFechaHoraBajaIsNull();
}
