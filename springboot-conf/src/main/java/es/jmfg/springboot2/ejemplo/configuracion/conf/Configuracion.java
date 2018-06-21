package es.jmfg.springboot2.ejemplo.configuracion.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class Configuracion {
	private boolean condicion;
	private String mensaje;
	private int numero;

	public boolean isCondicion() {
		return condicion;
	}

	public void setCondicion(boolean condicion) {
		this.condicion = condicion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}