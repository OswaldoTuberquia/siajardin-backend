package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.Proceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoJpaRepository extends JpaRepository<Proceso,Long>{
    
}
