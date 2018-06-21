package es.jmfg.springboot2.ejemplo.rest.basico.excepcion;

public class TuristaNotFoundException extends RuntimeException {

	public TuristaNotFoundException(String exception) {
		super(exception);
	}

}
