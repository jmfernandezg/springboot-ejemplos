package es.jmfg.springboot2.ejemplo.rest.basico.repo;

import es.jmfg.springboot2.ejemplo.rest.basico.modelo.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristaRepo extends JpaRepository<Turista, Long> {

}
