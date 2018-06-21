package es.jmfg.springboot2.ejemplo.hibernateh2.repo;

import es.jmfg.springboot2.ejemplo.hibernateh2.modelo.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Esta clase es más específica. Extiende JpaRepository
//  que a su vez extiende a PagingAndSortingRepository
public interface TuristaRepo extends JpaRepository<Turista, Long> {

}
