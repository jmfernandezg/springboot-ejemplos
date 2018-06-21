package es.jmfg.springboot2.ejemplo.hibernateh2;

import es.jmfg.springboot2.ejemplo.hibernateh2.modelo.Turista;
import es.jmfg.springboot2.ejemplo.hibernateh2.repo.TuristaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Repositorio de datos del turista
    @Autowired
    TuristaRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Operacion Buscar, Insertar, Actualizar, Eliminar
        logger.info("Turista id 106 -> {}", repo.findById(106L));
        logger.info("Insertando -> {}", repo.save(new Turista("Spencer", "X46")));
        logger.info("Actualizando 102 -> {}", repo.save(new Turista(102L, "-- ACTUALIZADO NOMBRE--", "-- ACTUALIZADO PASAPORTE---")));
        logger.info("Eliminando 104");
        repo.deleteById(104L);
        logger.info("Todos los Turistas -> {}", repo.findAll());
    }
}
