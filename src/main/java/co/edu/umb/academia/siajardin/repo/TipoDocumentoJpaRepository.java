package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoJpaRepository extends JpaRepository<TipoDocumento, String>{
    
}
