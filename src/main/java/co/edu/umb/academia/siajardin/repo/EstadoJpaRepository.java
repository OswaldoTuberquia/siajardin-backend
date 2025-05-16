package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoJpaRepository extends JpaRepository<Estado, Long>{
    
}
