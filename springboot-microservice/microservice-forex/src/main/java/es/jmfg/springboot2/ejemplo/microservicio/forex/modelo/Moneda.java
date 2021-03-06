package es.jmfg.springboot2.ejemplo.microservicio.forex.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Moneda {
    @Id
    private Long id;

    private String desde;

    private String hacia;

    private BigDecimal multiplo;

    public Moneda() {

    }

    public Moneda(Long id, String desde, String hacia, BigDecimal multiplo) {
        this.id = id;
        this.desde = desde;
        this.hacia = hacia;
        this.multiplo = multiplo;
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
}