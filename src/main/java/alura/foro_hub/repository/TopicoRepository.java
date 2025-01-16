package alura.foro_hub.repository;

import alura.foro_hub.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
