package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.ProcesoCalendario;
import co.edu.umb.academia.siajardin.model.ProcesoCalendarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcesoCalendarioJpaRepository extends JpaRepository<ProcesoCalendario, ProcesoCalendarioPK>{
    
}
