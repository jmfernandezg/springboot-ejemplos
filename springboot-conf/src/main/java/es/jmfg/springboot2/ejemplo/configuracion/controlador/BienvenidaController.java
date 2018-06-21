package es.jmfg.springboot2.ejemplo.configuracion.controlador;

import java.util.HashMap;
import java.util.Map;

import es.jmfg.springboot2.ejemplo.configuracion.conf.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador de la bienvenida
@RestController
public class BienvenidaController {

	// Mensaje de bienvenida definido en application-(dev|qa|prod)
	@Value("${bienvenida.mensaje}")
	private String mensajeBienvenida;

	@GetMapping("/bienvenida")
	public String bienvenida() {
		return mensajeBienvenida;
	}

	@Autowired
	private Configuracion configuration;

	// Responde en http://localhost:8080/configuracion
	@RequestMapping("/configuracion")
	public Map<String, Object> configuracion() {
		Map<String, Object> map = new HashMap<>();
		map.put("mensaje", configuration.getMensaje());
		map.put("numero", configuration.getNumero());
		map.put("condicion", configuration.isCondicion());
		return map;
	}
}