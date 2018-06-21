package es.jmfg.springboot2.ejemplo.rest.hateoas.modelo;

import java.util.Date;

// Modelo de una respuesta
public class Respuesta {
    private Date fecha;
    private String mensaje;
    private String detalles;

    public Respuesta(Date fecha, String mensaje, String detalles) {
        super();
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

}