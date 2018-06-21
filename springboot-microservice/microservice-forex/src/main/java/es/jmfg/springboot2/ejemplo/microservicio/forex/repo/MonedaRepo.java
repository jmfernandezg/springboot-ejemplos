package es.jmfg.springboot2.ejemplo.microservicio.forex.repo;

import es.jmfg.springboot2.ejemplo.microservicio.forex.modelo.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepo extends JpaRepository<Moneda, Long> {
    Moneda findByDesdeAndHacia(String desde, String hacia);
}