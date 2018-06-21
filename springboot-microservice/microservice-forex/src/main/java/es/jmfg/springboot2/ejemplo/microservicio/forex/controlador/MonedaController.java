package es.jmfg.springboot2.ejemplo.microservicio.forex.controlador;

import es.jmfg.springboot2.ejemplo.microservicio.forex.modelo.Moneda;
import es.jmfg.springboot2.ejemplo.microservicio.forex.repo.MonedaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonedaController {
@Autowired
    private MonedaRepo repo;

    @GetMapping("/cotizar-moneda/desde/{desde}/hacia/{hacia}")
    public Moneda retrieveExchangeValue(@PathVariable String desde, @PathVariable String hacia) {

        // Encontramos la moneda en la base de datos
        Moneda moneda = repo.findByDesdeAndHacia(desde, hacia);

        return moneda;
    }
}