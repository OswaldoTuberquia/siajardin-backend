package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroJpaRepository extends JpaRepository<Genero, Long>{
    
}
