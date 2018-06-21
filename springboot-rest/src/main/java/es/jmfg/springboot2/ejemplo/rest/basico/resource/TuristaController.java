package es.jmfg.springboot2.ejemplo.rest.basico.resource;

import es.jmfg.springboot2.ejemplo.rest.basico.modelo.Turista;
import es.jmfg.springboot2.ejemplo.rest.basico.excepcion.TuristaNotFoundException;
import es.jmfg.springboot2.ejemplo.rest.basico.repo.TuristaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TuristaController {

    @Autowired
    private TuristaRepo repo;

    @GetMapping("/turistas")
    public List<Turista> retrieveAllTuristas() {
        return repo.findAll();
    }

    @GetMapping("/turistas/{id}")
    public Turista retrieveTurista(@PathVariable long id) {
        Optional<Turista> Turista = repo.findById(id);

        if (!Turista.isPresent())
            throw new TuristaNotFoundException("id-" + id);

        return Turista.get();
    }

    @DeleteMapping("/turistas/{id}")
    public void deleteTurista(@PathVariable long id) {
        repo.deleteById(id);
    }

    @PostMapping("/turistas")
    public ResponseEntity<Object> createTurista(@RequestBody Turista Turista) {
        Turista savedTurista = repo.save(Turista);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedTurista.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/turistas/{id}")
    public ResponseEntity<Object> updateTurista(@RequestBody Turista Turista, @PathVariable long id) {

        Optional<Turista> TuristaOptional = repo.findById(id);

        if (!TuristaOptional.isPresent())
            return ResponseEntity.notFound().build();

        Turista.setId(id);

        repo.save(Turista);

        return ResponseEntity.noContent().build();
    }
}
