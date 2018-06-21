package es.jmfg.springboot2.ejemplo.microservicio.cotizador.modelo;

import java.math.BigDecimal;

public class Cotizacion {
    private Long id;
    private String desde;
    private String hacia;
    private BigDecimal multiplo;
    private BigDecimal total;

    public Cotizacion() {
    }

    public Cotizacion(Long id, String desde, String hacia, BigDecimal multiplo, BigDecimal cantidad) {
        this.id = id;
        this.desde = desde;
        this.hacia = hacia;
        this.multiplo = multiplo;
        total = cantidad.multiply(multiplo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHacia() {
        return hacia;
    }

    public void setHacia(String hacia) {
        this.hacia = hacia;
    }

    public BigDecimal getMultiplo() {
        return multiplo;
    }

    public void setMultiplo(BigDecimal multiplo) {
        this.multiplo = multiplo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
