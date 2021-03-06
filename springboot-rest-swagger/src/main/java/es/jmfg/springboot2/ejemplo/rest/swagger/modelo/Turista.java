package es.jmfg.springboot2.ejemplo.rest.swagger.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turista {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String pasaporte;

	public Turista() {
		super();
	}

	public Turista(Long id, String nombre, String pasaporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pasaporte = pasaporte;
	}

	public Turista(String nombre, String pasaporte) {
		super();
		this.nombre = nombre;
		this.pasaporte = pasaporte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	@Override
	public String toString() {
		return String.format("Turista [id=%s, nombre=%s, pasaporte=%s]", id, nombre, pasaporte);
	}

}
