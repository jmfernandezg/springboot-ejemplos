package es.jmfg.springboot2.ejemplo.rest.excepcion.excepcion;

// Excepcion de turista no encontrado
public class TuristaNotFoundException extends RuntimeException {

	public TuristaNotFoundException(String exception) {
		super(exception);
	}

}
