package es.jmfg.springboot2.ejemplo.microservicio.cotizador.controlador;

import es.jmfg.springboot2.ejemplo.microservicio.cotizador.modelo.Cotizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// Controlador de la conversi
@RestController
public class CotizacionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Proxy proxy;

    @GetMapping("/cotizar/desde/{desde}/hacia/{hacia}/cantidad/{cantidad}")
    public Cotizacion cotizar(@PathVariable String desde, @PathVariable String hacia, @PathVariable BigDecimal cantidad) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("desde", desde);
        uriVariables.put("hacia", hacia);

        ResponseEntity<Cotizacion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8081/cotizar-moneda/desde/{desde}/hacia/{hacia}", Cotizacion.class,
                uriVariables);
        Cotizacion response = responseEntity.getBody();
        return new Cotizacion(response.getId(), desde, hacia, response.getMultiplo(), cantidad);
    }

    @GetMapping("/cotizar-feign/desde/{desde}/hacia/{hacia}/cantidad/{cantidad}")
    public Cotizacion cotizarFeign(@PathVariable String desde, @PathVariable String hacia, @PathVariable BigDecimal cantidad) {
        Cotizacion response = proxy.cotizarMoneda(desde, hacia);

        logger.info("{}", response);

        return new Cotizacion(response.getId(), desde, hacia, response.getMultiplo(), cantidad);
    }

}