package es.jmfg.springboot2.ejemplo.rest.filtro.modelo;
import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("AstronautaFilter")
public class Astronauta {
  private String nombre;
  private int edad;
  private String nacionalidad;

  public Astronauta() {
  }

  public Astronauta(String nombre, int edad, String nacionalidad) {
    this.nombre = nombre;
    this.edad = edad;
    this.nacionalidad = nacionalidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }
}