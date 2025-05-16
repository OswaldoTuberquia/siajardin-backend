package co.edu.umb.academia.siajardin.repo;

import co.edu.umb.academia.siajardin.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioJpaRepository extends JpaRepository<Calendario, Long>{
   
}
