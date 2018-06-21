package es.jmfg.springboot2.ejemplo.microservicio.cotizador.controlador;

import es.jmfg.springboot2.ejemplo.microservicio.cotizador.modelo.Cotizacion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Esta clase de alguna manera va a descubrir el servicio FOREX
@FeignClient(name = "microservicio-forex")
@RibbonClient(name = "microservicio-forex")
public interface Proxy {
    @GetMapping("/cotizar-moneda/desde/{desde}/hacia/{hacia}")
    Cotizacion cotizarMoneda(@PathVariable("desde") String desde, @PathVariable("hacia") String hacia);
}