package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoljpaRepository extends JpaRepository<Rol, Long>{
    
}
