package es.jmfg.springboot2.ejemplo.rest.excepcion.controlador;


import es.jmfg.springboot2.ejemplo.rest.excepcion.excepcion.TuristaNotFoundException;
import es.jmfg.springboot2.ejemplo.rest.excepcion.modelo.Turista;
import es.jmfg.springboot2.ejemplo.rest.excepcion.repo.TuristaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TuristaController {

    @Autowired
    private TuristaRepo repo;

    @GetMapping("/turistas")
    public List<Turista> lista() {
        return repo.findAll();
    }

    @GetMapping(path = "/turistas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Turista> turista(@PathVariable long id) {
        Optional<Turista> turista = repo.findById(id);

        if (!turista.isPresent())
            throw new TuristaNotFoundException(String.format("Turista con id [%d] No Encontrado!", id));

        Resource<Turista> resource = new Resource<Turista>(turista.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).lista());
        resource.add(linkTo.withRel("all-turistas"));

        return resource;
    }

    @DeleteMapping("/turistas/{id}")
    public void deleteTurista(@PathVariable long id) {
        repo.deleteById(id);
    }

    @PostMapping("/turistas")
    public ResponseEntity<Object> createTurista(@RequestBody Turista turista) {
        Turista savedTurista = repo.save(turista);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTurista.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/turistas/{id}")
    public ResponseEntity<Object> updateTurista(@RequestBody Turista turista, @PathVariable long id) {

        Optional<Turista> turistaOptional = repo.findById(id);

        if (!turistaOptional.isPresent())
            return ResponseEntity.notFound().build();

        turista.setId(id);

        repo.save(turista);

        return ResponseEntity.noContent().build();
    }
}
