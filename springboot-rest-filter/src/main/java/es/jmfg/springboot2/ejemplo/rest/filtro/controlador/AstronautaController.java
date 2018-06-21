package es.jmfg.springboot2.ejemplo.rest.filtro.controlador;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import es.jmfg.springboot2.ejemplo.rest.filtro.modelo.Astronauta;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AstronautaController {

    @GetMapping("/astronautas")
    public MappingJacksonValue lista() {

        // Este filtro deja feura la edad
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("nombre", "nacionalidad");
        FilterProvider filters = new SimpleFilterProvider().addFilter("AstronautaFilter", filter);

        List<Astronauta> list = Arrays.asList(
                new Astronauta("Alexander Gerst", 42, "Aleman"),
                new Astronauta("Thomas Pesquet", 40, "Frances"),
                new Astronauta("Eric Boe", 53, "Americano"),
                new Astronauta("Jenni Sidey", 29, "Canadiense")

        );
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;

    }

    @GetMapping("/astronauta")
    public MappingJacksonValue astronauta() {
        Astronauta astro = new Astronauta("Tim Peake", 46, "Ingles");

        // Este filtro deja fuera la nacionalidad
        SimpleBeanPropertyFilter filtro = SimpleBeanPropertyFilter.filterOutAllExcept("nombre", "edad");
        FilterProvider filtros = new SimpleFilterProvider().addFilter("AstronautaFilter", filtro);

        MappingJacksonValue jacksonValue = new MappingJacksonValue(astro);
        jacksonValue.setFilters(filtros);

        return jacksonValue;

    }
}
