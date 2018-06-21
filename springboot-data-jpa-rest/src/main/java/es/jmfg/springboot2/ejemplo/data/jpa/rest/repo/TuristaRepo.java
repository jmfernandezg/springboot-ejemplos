package es.jmfg.springboot2.ejemplo.data.jpa.rest.repo;

import es.jmfg.springboot2.ejemplo.data.jpa.rest.modelo.Turista;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Extiende la clase PagingAndSortingRepository de Spring Data
@RepositoryRestResource(path = "turistas", collectionResourceRel = "turistas")
public interface TuristaRepo extends PagingAndSortingRepository<Turista, Long>{

}
